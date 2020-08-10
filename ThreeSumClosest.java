import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum, minSum = 0;
        int l, r;
        for(int i = 0; i < nums.length - 2; i++) {
            l = i + 1; r = nums.length - 1;
            while(l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if(sum == target) {
                    return target;
                }
                else if(sum < target) {
                    l++;
                }
                else {
                    r--;
                }
                if(Math.abs(target - sum) < min) {
                    min = Math.abs(target - sum);
                    minSum = sum;
                }
            }
        }
        return minSum;
    }
}