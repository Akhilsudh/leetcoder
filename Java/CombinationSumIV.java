/*  https://leetcode.com/problems/combination-sum-iv/
    Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
    Example:
        nums = [1, 2, 3]
        target = 4
    The possible combination ways are:
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)
        Note that different sequences are counted as different combinations.
        Therefore the output is 7.
*/
import java.util.*;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] lookup = new int[target + 1];
        Arrays.fill(lookup, -1);
        return helper(nums, lookup, target);
    }
    
    private int helper(int[] nums, int[] dp, int target) {
        if(target == 0) {
            return 1;
        }
        else if(target < 0) {
            return 0;
        }
        else if(dp[target] != -1) {
            return dp[target];
        }
        else {
            int result = 0;
            for(int num: nums) {
                result += helper(nums, dp, target - num);
            }
            dp[target] = result;
            return result;
        }
    }
}
