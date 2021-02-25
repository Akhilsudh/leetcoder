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
      if(max <= nums[i]) {
        max = nums[i];
      }
      if(nums[i] < max) {
        end = i;
      }
    }
    for(int i = nums.length - 1; i >= 0; i--) {
      if(min >= nums[i]) {
        min = nums[i];
      }
      if(nums[i] > min) {
        begin = i;
      }
    }
    return end - begin + 1;
  }
}
