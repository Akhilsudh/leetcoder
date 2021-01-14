/*  https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
    You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost 
    or the rightmost element from the array nums and subtract its value from x. Note that this modifies the 
    array for future operations. Return the minimum number of operations to reduce x to exactly 0 if it's possible, 
    otherwise, return -1.
    
    Example 1:
      Input: nums = [1,1,4,2,3], x = 5
      Output: 2
      Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
    
    Example 2:
      Input: nums = [5,6,7,8,9], x = 4
      Output: -1
    
    Example 3:
      Input: nums = [3,2,20,1,1,3], x = 10
      Output: 5
      Explanation: The optimal solution is to remove the last three elements and the first two elements 
      (5 operations in total) to reduce x to zero.
*/
import java.util.*;

public class shortestPathToZero {
  public int minOperations(int[] nums, int x) {
    List<Integer> list = new ArrayList<Integer>();
    for(int num: nums) {
      list.add(num);
    }
    int result = getShortestPath(list, x, 0);
    return (result == Integer.MAX_VALUE) ? -1 : result;
  }

  int getShortestPath(List<Integer> list, int x, int count) {
    if(x == 0) {
      return count;
    }
    else if(x < 0 || list.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    else {
      count += 1;
      List<Integer> listCopy = new ArrayList<Integer>(list);
      int diff = listCopy.get(0); 
      listCopy.remove(0);
      int a = getShortestPath(listCopy, x - diff, count);
      listCopy = new ArrayList<Integer>(list);
      diff = listCopy.get(listCopy.size() - 1); 
      listCopy.remove(listCopy.size() - 1);
      int b = getShortestPath(listCopy, x - diff, count);
      return Math.min(a, b);
    }
  }

  public static void main(String[] args) {
    shortestPathToZero obj = new shortestPathToZero();
    System.out.println(obj.minOperations(new int[]{1,1,4,2,3}, 5));
    System.out.println(obj.minOperations(new int[]{5,6,7,8,9}, 4));
    System.out.println(obj.minOperations(new int[]{3,2,20,1,1,3}, 10));
  }
}
