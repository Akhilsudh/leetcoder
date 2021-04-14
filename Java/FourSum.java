/*  https://leetcode.com/problems/4sum/
    Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
    Find all unique quadruplets in the array which gives the sum of target.
    Note:
    The solution set must not contain duplicate quadruplets.

    Example:
    Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
    A solution set is:
    [
        [-1,  0, 0, 1],
        [-2, -1, 1, 2],
        [-2,  0, 0, 2]
    ]
*/

import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int l, r, sum;
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                l = j + 1;  r = nums.length - 1;
                while(l < r) {
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target) {
                        result.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {nums[i], nums[j], nums[l],nums[r]})));
                        l++;
                        r--;
                    }
                    else if(sum < target) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}
