
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        boolean sorted = true;
        char minChar = arr[0];
        char maxChar = arr[0];

        for (int i = 0; i < n; i++) {
            minChar = (char) Math.min(minChar, arr[i]);
            maxChar = (char) Math.max(maxChar, arr[i]);

            if (i > 0 && arr[i] < arr[i - 1]) {
                sorted = false;
            }
        }

        // Already sorted
        if (sorted) {
            return 0;
        }

        // Cannot sort the entire string in one operation
        if (n == 2) {
            return -1;
        }

        // Minimum is at the beginning or maximum at the end
        if (arr[0] == minChar || arr[n - 1] == maxChar) {
            return 1;
        }

        // Minimum or maximum is in the middle
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == minChar || arr[i] == maxChar) {
                return 2;
            }
        }

        // Minimum is at the end and maximum at the beginning
        return 3;
    }
}
