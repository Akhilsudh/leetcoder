/*  https://leetcode.com/problems/running-sum-of-1d-array/
    Given an array nums. We define a running sum of an array as 
    runningSum[i] = sum(nums[0]…nums[i]). Return the running sum of nums.

    Example 1:
      Input: nums = [1,2,3,4]
      Output: [1,3,6,10]
      Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
*/
public class RunningSumOf1dArray {
  public int[] runningSum(int[] nums) {
    int[] result = new int[nums.length];
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      result[i] = sum;
    }
    return result;
  }

  private void printArray(int[] nums) {
    System.out.print("[ ");
    for(int num: nums) {
      System.out.print(num + " ");
    }
    System.out.println("]");
  }
  public static void main(String[] args) {
    RunningSumOf1dArray obj = new RunningSumOf1dArray();
    obj.printArray(obj.runningSum(new int[] {1, 1, 1, 1, 1}));
    obj.printArray(obj.runningSum(new int[] {1, 2, 3, 4}));
    obj.printArray(obj.runningSum(new int[] {3, 1, 2, 10, 1}));
  }
}
