import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                int val = nCr(i, j);
                temp.add(val);
            }

            ans.add(temp);
        }

        return ans;
    }

    public int nCr(int row, int col) {
        long res = 1;

        for (int i = 0; i < col; i++) {
            res = res * (row - i) / (i + 1);
        }

        return (int) res;
    }
}
//  class Solution {
//      public List<List<Integer>> generate(int numRows) {
//          List<List<Integer>> result = new ArrayList<>();

//          for (int i = 0; i < numRows; i++) {
//              List<Integer> row = new ArrayList<>();

//              for (int j = 0; j <= i; j++) {
//                 if (j == 0 || j == i) {
//                   row.add(1);
//                  } else {
//                      row.add(result.get(i - 1).get(j - 1)
//                             + result.get(i - 1).get(j));
//                  }
//              }

//              result.add(row);
//          }

//       return result;
//      }
 //}
