package Grind75;
import java.util.*;
public class _43_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recurse(candidates, target, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void recurse(int[] candidates, int target, List<List<Integer>> result, List<Integer> intermedate, int start) {
        if(target == 0) {
            result.add(intermedate);
        } else if(target < 0) {
            intermedate = null;
        } else {
            for(int i = start; i < candidates.length; i++) {
                List<Integer> intermediate1 = new ArrayList<>(intermedate);
                intermediate1.add(candidates[i]);
                recurse(candidates, target - candidates[i], result, intermediate1, i);
            }
        }
    }

    public static void main(String[] args) {
        _43_CombinationSum obj = new _43_CombinationSum();
        System.out.println(obj.combinationSum(new int[] {2,3,6,7}, 7));
    }
}
