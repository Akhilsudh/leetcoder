package Grind75;

public class _25_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int temp = 0;
        for(int num: nums) {
            temp += num;
            if(temp > maxSum) {
                maxSum = temp;
            }
            if(temp < 0) {
                temp = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        _25_MaximumSubarray obj = new _25_MaximumSubarray();
        System.out.println(obj.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(obj.maxSubArray(new int[] {-2}));
        System.out.println(obj.maxSubArray(new int[] {5,4,-1,7,8}));
    }
}
