class Solution {
    public int[] sortedSquares(int[] nums) {
        // for(int i=0;i<nums.length;i++){
        //     nums[i]=nums[i]*nums[i];

        // }
        // Arrays.sort(nums);
        // return nums;
        int n=nums.length;
        int[] temp = new int[n];
        int left=0;
        int right = n-1;
        while(left<=right){
       
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                temp[n-1]=leftSquare;
                left++;
                n--;
            } else {
                temp[n-1] = rightSquare;
                n--;
                right--;
        
            }
        }

        return temp;
    }

}