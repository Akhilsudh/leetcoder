/*  https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
  Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), 
  return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
  A row i is weaker than row j, if the number of soldiers in row i is less than the number of 
  soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are 
  always stand in the frontier of a row, that is, always ones may appear first and then zeros.

  Example 1:
    Input: mat = 
    [[1,1,0,0,0],
    [1,1,1,1,0],
    [1,0,0,0,0],
    [1,1,0,0,0],
    [1,1,1,1,1]], 
    k = 3
    Output: [2,0,3]
    Explanation: 
    The number of soldiers for each row is: 
    row 0 -> 2 
    row 1 -> 4 
    row 2 -> 1 
    row 3 -> 2 
    row 4 -> 5 
    Rows ordered from the weakest to the strongest are [2,0,3,1,4]
*/
import java.util.*;
public class TheKWeakestRowsInAMatrix {
  public int[] kWeakestRows(int[][] mat, int k) {
    int[][] map = new int[mat.length][2];
    for(int i = 0; i < mat.length; i++) {
      int sum = 0;
      for(int j = 0; j < mat[i].length; j++) {
        sum += mat[i][j];
      }
      map[i][0] = sum;
      map[i][1] = i;      
    }
    Arrays.sort(map, new Comparator<int[]>() {
      @Override
      public int compare(int[] arr1, int[] arr2) {
        Integer num1 = (Integer) arr1[0];
        Integer num2 = (Integer) arr2[0];                
        return num1.compareTo(num2);
      }
    });
    int[] result = new int[k];
    for(int i = 0; i < k; i++) {
      result[i] = map[i][1];
    }
    return result;
  }
}
