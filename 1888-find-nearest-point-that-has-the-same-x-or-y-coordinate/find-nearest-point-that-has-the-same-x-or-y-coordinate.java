class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {

        int minDistance = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 0; i < points.length; i++) {

            int px = points[i][0];
            int py = points[i][1];

            // Same x OR same y
            if (px == x || py == y) {

                int distance = Math.abs(px - x) + Math.abs(py - y);

                if (distance < minDistance) {
                    minDistance = distance;
                    answer = i;
                }
            }
        }

        return answer;
    }
}