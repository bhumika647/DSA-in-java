class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            int val=nCr(rowIndex,i);
            ans.add(val);
        }
        return ans;
    }
    public static int nCr(int r,int c){
        long result=1;
        for(int i=0;i<c;i++){
            result=result*(r-i);
            result=result/(i+1);
        }
        return (int) result;
    }
}