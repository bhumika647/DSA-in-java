class Solution {
    public int removeDuplicates(int[] nums) {
        
        int prev = Integer.MIN_VALUE;
        int count =0;
        for(int n:nums){
            if(n!=prev){
                nums[count++]=n;
                prev=n;
            }
        }
        return count;
    }
}