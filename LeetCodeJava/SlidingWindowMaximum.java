import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> (j - i));
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == k) {
                count -= 1;
                int maxValue = maxHeap.peek();
                maxHeap.remove(nums[i - k]);
                result[resultIndex] = maxValue;
                resultIndex++;
            }
            maxHeap.offer(nums[i]);
            count++;
        }
        result[resultIndex] = maxHeap.peek();
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();

        int[] result1 = obj.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(result1));

        int[] result2 = obj.maxSlidingWindow(new int[] {9,10,9,-7,-4,-8,2,-6}, 5);
        System.out.println(Arrays.toString(result2));
    }
}
