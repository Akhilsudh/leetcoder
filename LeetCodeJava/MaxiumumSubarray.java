/*
https://leetcode.com/problems/maximum-subarray/
Maxiumum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
*/

public class MaxiumumSubarray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int sum = dp[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxiumumSubarray obj = new MaxiumumSubarray();

        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(obj.maxSubArray(arr));

        arr = new int[] {1};
        System.out.println(obj.maxSubArray(arr));

        arr = new int[] {5,4,-1,7,8};
        System.out.println(obj.maxSubArray(arr));
    }
}
