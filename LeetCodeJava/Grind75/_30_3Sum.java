// DID NOT SOLVE AS EXPECTED
// Sort two pointers

package Grind75;

import java.util.*;

public class _30_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, LinkedHashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k-> new LinkedHashSet<>());
            map.get(nums[i]).add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int target = - nums[i];
            map.get(nums[i]).remove(i);
            for(int j = i + 1; j < nums.length; j++) {
                map.get(nums[j]).remove(j);
                if(map.containsKey(target - nums[j]) && !map.get(target - nums[j]).isEmpty()) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target - nums[j]);
                    result.add(list);
                    map.get(target - nums[j]).remove(map.get(target - nums[j]).getFirst());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _30_3Sum obj = new _30_3Sum();
        System.out.println(obj.threeSum(new int[] {-1,0,1,2,-1,-4}));
        System.out.println(obj.threeSum(new int[] {0,1,1}));
        System.out.println(obj.threeSum(new int[] {0,0,0}));
        System.out.println(obj.threeSum(new int[] {0,0,0,0}));
    }
}
