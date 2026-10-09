
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;

        int sum = 0;
        int result = 0;

        for (int num : nums) {
            sum += num;

            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }

            result += count[rem];
            count[rem]++;
        }

        return result;
    }
}
