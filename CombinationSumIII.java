/*  https://leetcode.com/problems/combination-sum-iii
    Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

    Note:
    All numbers will be positive integers.
    The solution set must not contain duplicate combinations.

    Example 1:
    Input: k = 3, n = 7
    Output: [[1,2,4]]

    Example 2:
    Input: k = 3, n = 9
    Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(arr, result, new ArrayList<Integer>(), 0, k, n);
        return result;
    }

    private void helper(int[] arr, List<List<Integer>> result, List<Integer> list,int index, int k, int n) {
        if(k == 0) {
            if(n == 0) {
                result.add(new ArrayList<Integer>(list));
                return;
            }
            return;
        }
        else if(index < arr.length) {
            if(n - arr[index] >= 0) {
                list.add(arr[index]);
                helper(arr, result, list, index + 1, k - 1, n - arr[index]);
                list.remove(list.size() - 1);
            }
            helper(arr, result, list, index + 1, k, n);
            return;   
        }
        else {
            return;
        }
    }
}