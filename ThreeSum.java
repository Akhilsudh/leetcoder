import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l, r, sum;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++) {
            if((i > 0) && (nums[i] == nums[i-1])) {
                continue;
            }
            l = i + 1; r = nums.length - 1;
            while(l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {nums[i], nums[l], nums[r]})));
                }
                if(sum <= 0) {
                    l++;
                    while(l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
                if(sum >= 0) {
                    r--;
                    while(l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
        return result;
    }
}