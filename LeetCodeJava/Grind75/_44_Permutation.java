package Grind75;

import java.util.*;
import java.util.stream.Collectors;

public class _44_Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, Arrays.stream(nums).boxed().toList());
        return result;
    }

    private void helper(List<List<Integer>> results, List<Integer> nums) {
        if(nums.size() == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums.get(0));
            results.add(list);
        } else {
            for(Integer num: nums) {
                List<Integer> tempList = new ArrayList<>();
                for(Integer num2: nums) {
                    if(!Objects.equals(num, num2)) {
                        tempList.add(num2);
                    }
                }
                helper(results, tempList);
                for(List<Integer> result: results) {
                    result.add(num);
                }
            }
        }
    }
}
