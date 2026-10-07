class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] ans = new int[n * m];
        int index = 0;

        for (int d = 0; d < n + m - 1; d++) {

            if (d % 2 == 0) {
                // Up-right
                int row = Math.min(d, n - 1);
                int col = d - row;

                while (row >= 0 && col < m) {
                    ans[index++] = mat[row][col];
                    row--;
                    col++;
                }

            } else {
                // Down-left
                int col = Math.min(d, m - 1);
                int row = d - col;

                while (row < n && col >= 0) {
                    ans[index++] = mat[row][col];
                    row++;
                    col--;
                }
            }
        }

        return ans;
    }
}