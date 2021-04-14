/*  https://leetcode.com/problems/house-robber-ii/
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, 
adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses 
were broken into on the same night. Given a list of non-negative integers nums representing the amount of money of each 
house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
    Input: nums = [2,3,2]
    Output: 3
    Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

Example 3:
    Input: nums = [0]
    Output: 0
*/
public class HouseRobberII {
    public int rob(int[] nums) {
        return Math.max(robHouse(nums, 0), robHouse(nums, 1));
    }

    private int robHouse(int [] nums, int index) {
        if(nums.length < 2) {
            return (nums.length == 0) ? 0 : nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int [] result = new int[nums.length];
        result[0 + index] = nums[0 + index];
        result[1 + index] = (nums[0 + index] > nums[1 + index]) ? nums[0 + index] : nums[1 + index];
        for(int i = 2 + index; i < nums.length - (1 - index); i++) {
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return result[nums.length - (2 - index)];
    }

    public static void main(String[] args) {
        HouseRobberII obj = new HouseRobberII();
        System.out.println(obj.rob(new int[] {1}));
        System.out.println(obj.rob(new int[] {3,1}));
        System.out.println(obj.rob(new int[] {1,2,4}));
        System.out.println(obj.rob(new int[] {1,2,3,1}));
        System.out.println(obj.rob(new int[] {2,7,9,3,1}));
        System.out.println(obj.rob(new int[] {2,7,9,3,1,10,2,1}));
    }
}
