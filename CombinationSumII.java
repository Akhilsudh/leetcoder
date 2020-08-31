import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> results = new HashSet<List<Integer>>();
        backTrack(candidates, results, new ArrayList<Integer>(), 0, target);
        return new ArrayList<List<Integer>>(results);
    }

    private void backTrack(int[] candidates, Set<List<Integer>> results, List<Integer> result, int index, int target) {
        if(target < 0) {
            return;
        }
        else if(target == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        else if(index < candidates.length) {
            result.add(candidates[index]);
            backTrack(candidates, results, result, index + 1, target - candidates[index]);
            result.remove(result.size() - 1);
            backTrack(candidates, results, result, index + 1, target);
        }
        else {
            return;
        }
    }

    public static void main(String args[]) {
        CombinationSumII obj = new CombinationSumII();
        System.out.println(obj.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        System.out.println(obj.combinationSum2(new int[] {2,5,2,1,2}, 5));
        System.out.println(obj.combinationSum2(new int[] {1,2,3}, 6));
        System.out.println(obj.combinationSum2(new int[] {1,2,3}, 7));
    }
}