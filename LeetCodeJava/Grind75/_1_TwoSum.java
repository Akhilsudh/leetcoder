package Grind75;

import java.util.*;

public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            Integer temp = map.get(target - nums[i]);
            if(temp != null && i != temp) {
                return new int[] {i, temp};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _1_TwoSum obj = new _1_TwoSum();
        System.out.println(Arrays.toString(obj.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(obj.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(obj.twoSum(new int[]{3, 3}, 6)));
    }
}
