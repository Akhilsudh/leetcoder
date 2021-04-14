import java.util.*;

// Initial solution using extra space
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> freq = new HashSet<Integer>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(freq.contains(nums[i])) {
                result.add(nums[i]);
            }
            freq.add(nums[i]);
        }
        return result;
    }
}
