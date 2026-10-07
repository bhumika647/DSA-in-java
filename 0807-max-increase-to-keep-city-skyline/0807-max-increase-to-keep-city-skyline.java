class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] rowMax = new int[n];
        int[] colMax = new int[m];

        // Find maximum in every row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int answer = 0;

        // Maximum possible height at (i, j)
        // is min(rowMax[i], colMax[j])
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxHeight = Math.min(rowMax[i], colMax[j]);
                answer += maxHeight - grid[i][j];
            }
        }

        return answer;
    }
}