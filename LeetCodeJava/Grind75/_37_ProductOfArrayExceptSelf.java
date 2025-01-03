package Grind75;

public class _37_ProductOfArrayExceptSelf {

    // 1, 2 , 3, 4
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            right = nums[i + 1] * right;
            result[i] = right * result[i + 1];
        }
        return result;
    }
}
