package Grind75;

import java.util.Arrays;

public class _19_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int result = nums[0];
        int count = 0;
        int tempNum = nums[0];
        int tempCount = 0;
        for(int num: nums) {
            if(num == tempNum) {
                tempCount++;
            } else {
                if(tempCount > count) {
                    count = tempCount;
                    result = tempNum;
                }
                tempCount = 1;
                tempNum = num;
            }
        }
        if(tempCount > count) {
            result = tempNum;
        }
        return result;
    }

    public static void main(String[] args) {
        _19_MajorityElement obj = new _19_MajorityElement();
        System.out.println(obj.majorityElement(new int[] {3,2,3}));
        System.out.println(obj.majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}
