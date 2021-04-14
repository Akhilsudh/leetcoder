import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        helper(candidates, result, new ArrayList<Integer>(), 0, target);
        return new ArrayList<List<Integer>>(result);
    }
    private void helper(int[] candidates, Set<List<Integer>> result, List<Integer> list, int index, int target) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        else if(index < candidates.length) {
            if(target - candidates[index] >= 0) {
                list.add(candidates[index]);
                helper(candidates, result, list, index, target - candidates[index]);
                list.remove(list.size() - 1);
            }
            helper(candidates, result, list, index + 1, target);
        }
        else {
            return;
        }
    }

    public static void main(String args[]) {
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(new int[] {2,3,6,7}, 7));
        System.out.println(obj.combinationSum(new int[] {2,3,5}, 8));
    }

}