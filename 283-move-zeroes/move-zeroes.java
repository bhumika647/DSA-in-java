// class Solution {
//     public void moveZeroes(int[] nums) {
//      int n=nums.length;
//      int count = 0;
//      for(int val:nums){
//         if(val!=0){
//             nums[count++]=val;
//         }
//      }   
//      while(count<n){
//         nums[count++]=0;
//      }
//     }
// }
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;  // position for next non-zero

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}