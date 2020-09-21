/*  https://leetcode.com/problems/first-missing-positive/
    Given an unsorted integer array, find the smallest missing positive integer.

    Example 1:
    Input: [1,2,0]
    Output: 3

    Example 2:
    Input: [3,4,-1,1]
    Output: 2

    Example 3:
    Input: [7,8,9,11,12]
    Output: 1

    Follow up:
    Your algorithm should run in O(n) time and uses constant extra space.
*/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(!(nums[i] <= 0 || nums[i] > nums.length) && (nums[i] != nums[nums[i] - 1])) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        if(nums[index1] != nums[index2]) {
            nums[index1] = nums[index1] ^ nums[index2];
            nums[index2] = nums[index1] ^ nums[index2];
            nums[index1] = nums[index1] ^ nums[index2];
        }
    }
}