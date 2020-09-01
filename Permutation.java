import java.util.*;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int index) {
        if(index == nums.length - 1 || nums.length == 0) {
            List<Integer> res = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i++) {
                res.add(nums[i]);
            }
            result.add(res);
            return;
        }
        else {
            for(int i = index; i < nums.length; i++) {
                swap(i, index, nums);
                backtrack(result, nums, index + 1);
                swap(i, index, nums);
            }
            return;
        }
    }

    private void swap(int index1, int index2, int[] numbers) {
        if(index1 == index2) {
            return;
        }
        numbers[index1] = numbers[index1] ^ numbers[index2];
        numbers[index2] = numbers[index1] ^ numbers[index2];
        numbers[index1] = numbers[index1] ^ numbers[index2];
        return;
    }

}