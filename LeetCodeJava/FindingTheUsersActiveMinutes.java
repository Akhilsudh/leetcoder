/*  https://leetcode.com/problems/finding-the-users-active-minutes/
    You are given the logs for users' actions on LeetCode, and an integer k. The logs are 
    represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that 
    he user with IDi performed an action at the minute time i. Multiple users can perform 
    actions simultaneously, and a single user can perform multiple actions in the same minute.
    The user active minutes (UAM) for a given user is defined as the number of unique minutes 
    in which the user performed an action on LeetCode. A minute can only be counted once, 
    even if multiple actions occur during it. You are to calculate a 1-indexed array answer 
    of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose 
    UAM equals j. Return the array answer as described above.

    Example 1:
      Input: logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
      Output: [0,2,0,0,0]
      Explanation:
      The user with ID=0 performed actions at minutes 5, 2, and 5 again. Hence, they have a UAM 
      of 2 (minute 5 is only counted once). The user with ID=1 performed actions at minutes 
      2 and 3. Hence, they have a UAM of 2. Since both users have a UAM of 2, answer[2] is 2, 
      and the remaining answer[j] values are 0.

*/
import java.util.*;

class FindingTheUsersActiveMinutes {
  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    int[] result = new int[k];
    for(int i = 0; i < logs.length; i++) {
      if(map.containsKey(logs[i][0])) {
        map.get(logs[i][0]).add(logs[i][1]);
      }
      else {
        Set<Integer> set = new HashSet<Integer>();
        set.add(logs[i][1]);
        map.put(logs[i][0], set);
      }
    }
    for(int user: map.keySet()) {
      int index = map.get(user).size() - 1;
      result[index] = result[index] + 1;
    }
    return result;
  }

  public static void main(String[] args) {
    FindingTheUsersActiveMinutes obj = new FindingTheUsersActiveMinutes();
    int[][] logs1 = {{0,5},{1,2},{0,2},{0,5},{1,3}};
    int k = 5;
    int[] result = obj.findingUsersActiveMinutes(logs1, k);
    System.out.print("[ ");
    for(int i: result) {
      System.out.print(i + " ");
    }
    System.out.println("]");
    int[][] logs2 = {{1,1},{2,2},{2,3}};
    k = 4;
    result = obj.findingUsersActiveMinutes(logs2, k);
    System.out.print("[ ");
    for(int i: result) {
      System.out.print(i + " ");
    }
    System.out.println("]");
  }
}