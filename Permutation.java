import java.util.*;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> numbers = new HashSet<Integer>();
        for(int num: nums) {
            numbers.add(num);
        }
        backtrack(result, new ArrayList<Integer>(), numbers);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, Set<Integer> numbers) {
        if(numbers.isEmpty()) {
            result.add(new ArrayList<>(list));
            return;
        }
        else {
            for(int number: numbers) {
                Set<Integer> newNumbers = new HashSet<Integer>(numbers);
                newNumbers.remove(number);
                list.add(number);
                int index = list.size() - 1;
                backtrack(result, list, newNumbers);
                list.remove(index);
            }
            return;
        }
    }
}