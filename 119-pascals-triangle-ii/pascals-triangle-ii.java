class Solution {
    public List<Integer> getRow(int rowIndex) {
       
       List<Integer> list =new ArrayList<>();
        if(rowIndex<0) return list;
        long ans = 1;
        list.add(1);
        for(int i=1;i<=rowIndex;i++){
            ans=ans*(rowIndex-i+1);
            ans/=i;
            list.add((int)ans);
        }
        return list;
    }
}
        // List<Integer> ans=new ArrayList<>();
//         for(int i=0;i<=rowIndex;i++){
//             int val=nCr(rowIndex,i);
//             ans.add(val);
//         }
//         return ans;
//     }
//     public static int nCr(int r,int c){
//         long result=1;
//         for(int i=0;i<c;i++){
//             result=result*(r-i);
//             result=result/(i+1);
//         }
//         return (int) result;
//     }
// }