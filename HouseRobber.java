/*  https://leetcode.com/problems/house-robber/
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of 
    money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have 
    security system connected and it will automatically contact the police if two adjacent houses were broken 
    into on the same night. Given a list of non-negative integers representing the amount of money of each house, 
    determine the maximum amount of money you can rob tonight without alerting the police.
    
    Example 1:
    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                Total amount you can rob = 1 + 3 = 4.
    Example 2:
    Input: nums = [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                Total amount you can rob = 2 + 9 + 1 = 12.
*/
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int [] result = new int[nums.length];
        int val1, val2;
        result[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            val1 = (0 > i - 2) ? 0 : result[i - 2];
            val2 = (0 > i - 1) ? 0 : result[i - 1];
            result[i] = Math.max(nums[i] + val1, val2);
        }
        return result[nums.length - 1];
    }

    private int recurse(int[] nums, int index) {
        if(index >= nums.length) {
            return 0;
        }
        else {
            return Math.max(nums[index] + recurse(nums, index + 2), recurse(nums, index + 1));
        }
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        System.out.println(obj.rob(new int[] {1,2,3,1}));
        System.out.println(obj.rob(new int[] {2,7,9,3,1}));
        System.out.println(obj.rob(new int[] {2,7,9,3,1,10,2}));
    }
}
