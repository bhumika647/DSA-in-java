
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        SegmentTree tree = new SegmentTree(n);
        long ans = 0;

        for (int r = 0; r < n; r++) {
            int x = nums[r];
            int prev = last[x];

            // Increase distinct counts for subarrays
            // whose starting index is in [prev + 1, r].
            tree.update(prev + 1, r, 1);

            // Sum of squared distinct counts for subarrays
            // ending at index r.
            ans = (ans + tree.sumSquares()) % MOD;

            last[x] = r;
        }

        return (int) ans;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] sq;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq = new long[4 * n];
            lazy = new long[4 * n];
        }

        // Add val to every element in a segment.
        void apply(int node, int l, int r, long val) {
            long len = r - l + 1L;

            sq[node] = (sq[node]
                    + 2L * val % MOD * sum[node] % MOD
                    + len * val % MOD * val % MOD) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void pushDown(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) {
                return;
            }

            int mid = l + (r - l) / 2;
            long val = lazy[node];

            apply(node * 2, l, mid, val);
            apply(node * 2 + 1, mid + 1, r, val);

            lazy[node] = 0;
        }

        void update(int ql, int qr, long val) {
            update(1, 0, n - 1, ql, qr, val);
        }

        void update(int node, int l, int r,
                    int ql, int qr, long val) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }

            pushDown(node, l, r);
            int mid = l + (r - l) / 2;

            if (ql <= mid) {
                update(node * 2, l, mid, ql, qr, val);
            }

            if (qr > mid) {
                update(node * 2 + 1, mid + 1, r,
                       ql, qr, val);
            }

            sum[node] = (sum[node * 2]
                    + sum[node * 2 + 1]) % MOD;

            sq[node] = (sq[node * 2]
                    + sq[node * 2 + 1]) % MOD;
        }

        long sumSquares() {
            return sq[1];
        }
    }
}
