/*  https://leetcode.com/problems/subsets-ii/
    Given a collection of integers that might contain duplicates,
    nums, return all possible subsets (the power set).
    Note: The solution set must not contain duplicate subsets.

    Example:
    Input: [1,2,2]
    Output:
    [
        [2],
        [1],
        [1,2,2],
        [2,2],
        [1,2],
        []
    ]
*/
import java.util.*;
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        backtrack(result, nums, 0, new ArrayList<Integer>());
        return new ArrayList<List<Integer>>(result);
    }

    private void backtrack(Set<List<Integer>> result, int [] nums, int index, List<Integer> list) {
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
        SubsetsII obj = new SubsetsII();
        System.out.println(obj.subsetsWithDup(new int[] {}));
        System.out.println(obj.subsetsWithDup(new int[] {1, 2, 2}));
        System.out.println(obj.subsetsWithDup(new int[] {1, 2, 3}));
        System.out.println(obj.subsetsWithDup(new int[] {4, 4, 4, 1, 4}));
    }
}