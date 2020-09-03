import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        backtrack(result, nums, 0);
        return new ArrayList<List<Integer>>(result);
    }

    private void dfs(Set<List<Integer>> result, int[] nums, int index) {
        if(index == nums.length - 1 || nums.length == 0) {
            List<Integer> resultList = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i++) {
                resultList.add(nums[i]);
            }
            result.add(resultList);
            return;
        }
        else {
            for(int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                backtrack(result, nums, index + 1);
                swap(nums, index, i);
            }
            return;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        if(arr[index1] == arr[index2]) {
            return;
        }
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
        return;
    }
}
