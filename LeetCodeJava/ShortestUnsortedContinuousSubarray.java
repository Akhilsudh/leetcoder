/*  https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
    Given an integer array nums, you need to find one continuous subarray that 
    if you only sort this subarray in ascending order, then the whole array will 
    be sorted in ascending order. Return the shortest such subarray and output 
    its length.

    Example 1:
      Input: nums = [2,6,4,8,10,9,15]
      Output: 5
      Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to 
      make the whole array sorted in ascending order.

    Example 2:
      Input: nums = [1,2,3,4]
      Output: 0
*/
public class ShortestUnsortedContinuousSubarray {
  public int findUnsortedSubarray(int[] nums) {
    if(nums.length <= 1) {
      return 0;
    }
    int begin = -1;
    int end = -2;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      end = (nums[i] < max) ? i : end;
    }
    for(int i = nums.length - 1; i >= 0; i--) {
      min = Math.min(min, nums[i]);
      begin = (nums[i] > min) ? i : begin;
    }
    return end - begin + 1;
  }

  public static void main(String[] args) {
    ShortestUnsortedContinuousSubarray obj = new ShortestUnsortedContinuousSubarray();
    System.out.println("The length of the shortes subarray to be sorted to sort the whole array [2,6,4,8,10,9,15] = " + obj.findUnsortedSubarray(new int[] {2,6,4,8,10,9,15}));
    System.out.println("The length of the shortes subarray to be sorted to sort the whole array [1,2,3,4] = " + obj.findUnsortedSubarray(new int[] {1,2,3,4}));
    System.out.println("The length of the shortes subarray to be sorted to sort the whole array [1] = " + obj.findUnsortedSubarray(new int[] {1}));
  }
}
