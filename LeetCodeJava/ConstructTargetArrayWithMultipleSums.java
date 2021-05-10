/*  https://leetcode.com/problems/construct-target-array-with-multiple-sums/
    Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :
        let x be the sum of all elements currently in your array.
        choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
        You may repeat this procedure as many times as needed.
    Return True if it is possible to construct the target array from A otherwise return False.

    Example 1:
      Input: target = [9,3,5]
      Output: true
      Explanation: Start with [1, 1, 1] 
      [1, 1, 1], sum = 3 choose index 1
      [1, 3, 1], sum = 5 choose index 2
      [1, 3, 5], sum = 9 choose index 0
      [9, 3, 5] Done
*/
import java.util.*;
public class ConstructTargetArrayWithMultipleSums {
  public boolean isPossible(int[] target) {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
    int sum = 0;
    for(int num: target) {
      sum += num;
      queue.add(num);
    }
    while(queue.peek() != 1) {
      int max = queue.poll();
      sum -= max;
      if(sum < 1 || max <= sum) {
        return false;
      }
      max -= sum;
      sum += max;
      queue.add(max);
    }
    return true;
  }

  public static void main(String[] args) {
    ConstructTargetArrayWithMultipleSums obj = new ConstructTargetArrayWithMultipleSums();
    System.out.println(obj.isPossible(new int[] {9, 3, 5}));
    System.out.println(obj.isPossible(new int[] {1, 1, 1, 1, 2}));
  }
}
