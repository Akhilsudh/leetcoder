/*  https://leetcode.com/problems/subsets/
    Given a set of distinct integers, nums, return all possible subsets (the power set).
    Note: The solution set must not contain duplicate subsets.
    Example:
    Input: nums = [1,2,3]
    Output:
    [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
    ]
*/
import java.util.*;
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int [] nums, int index, List<Integer> list) {
        if(index == nums.length || nums.length == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(result, nums, index + 1, list);
        list.remove(list.size() - 1);
        backtrack(result, nums, index + 1, list);
        return;
    }

    public static void main(String args[]) {
        Subsets obj = new Subsets();
        System.out.println(obj.subsets(new int[] {}));
        System.out.println(obj.subsets(new int[] {1, 2, 3}));
        System.out.println(obj.subsets(new int[] {3, 1, 2}));
    }
}