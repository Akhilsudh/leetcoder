package Grind75;

import java.util.*;

public class _24_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _24_ContainsDuplicate obj = new _24_ContainsDuplicate();
        System.out.println(obj.containsDuplicate(new int[] {1,2,3,1}));
        System.out.println(obj.containsDuplicate(new int[] {1}));
        System.out.println(obj.containsDuplicate(new int[] {1,2,3,4,5}));
        System.out.println(obj.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }
}
