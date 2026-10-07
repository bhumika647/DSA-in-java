class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int maxDiagonal = 0;
        int total = 0;

        // Group elements by i + j
        for (int i = 0; i < nums.size(); i++) {

            for (int j = 0; j < nums.get(i).size(); j++) {

                int diagonal = i + j;

                map.putIfAbsent(diagonal, new ArrayList<>());
                map.get(diagonal).add(nums.get(i).get(j));

                maxDiagonal = Math.max(maxDiagonal, diagonal);
                total++;
            }
        }

        int[] ans = new int[total];
        int index = 0;

        // Read each diagonal in reverse
        for (int d = 0; d <= maxDiagonal; d++) {

            List<Integer> list = map.get(d);

            if (list != null) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    ans[index++] = list.get(i);
                }
            }
        }

        return ans;
    }
}