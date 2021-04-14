/*  https://leetcode.com/problems/couples-holding-hands/
    N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number 
    of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then 
    they stand up and switch seats. The people and seats are represented by an integer from 0 to 2N-1, the 
    couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on 
    with the last couple being (2N-2, 2N-1). The couples' initial seating is given by row[i] being the value 
    of the person who is initially sitting in the i-th seat.

    Example 1:
      Input: row = [0, 2, 1, 3]
      Output: 1
      Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
    Example 2:
      Input: row = [3, 2, 0, 1]
      Output: 0
      Explanation: All couples are already seated side by side.
*/
import java.util.*;

public class CouplesHoldingHands {
  public int minSwapsCouples(int[] row) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int result = 0;
    for(int i = 0; i < row.length; i++) {
      map.put(row[i], i);
    }
    for(int i = 0; i < row.length; i += 2) {
      int nextMember = (row[i] % 2 == 0) ? row[i] + 1 : row[i] - 1;
      if(map.get(nextMember) == i + 1) {
        continue;
      }
      int temp1 = map.get(nextMember);
      map.put(nextMember, i + 1);
      map.put(row[i + 1], temp1);
      int temp2 = row[i + 1];
      row[i + 1] = nextMember;
      row[temp1] = temp2;
      result++;
    }
    return result;
  }

  public static void main(String[] args) {
    CouplesHoldingHands obj = new CouplesHoldingHands();
    System.out.println("Number of swaps for couple [0, 2, 1, 3] = " + obj.minSwapsCouples(new int[] {0, 2, 1, 3}));
    System.out.println("Number of swaps for couple [3, 2, 0, 1] = " + obj.minSwapsCouples(new int[] {3, 2, 0, 1}));
  }
}
