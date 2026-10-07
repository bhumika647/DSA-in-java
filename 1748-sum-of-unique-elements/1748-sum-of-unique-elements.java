class Solution {
    public int sumOfUnique(int[] nums) {
        int[] frequency = new int[101];

        for (int num : nums) {
            frequency[num]++;
        }

        int sum = 0;

        for (int num : nums) {
            if (frequency[num] == 1) {
                sum += num;
            }
        }

        return sum;
    }
}