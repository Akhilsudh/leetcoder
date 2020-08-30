import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // Find the first number that is no increasing from the right
        int index = -1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if(index >= 0) {
            int swapIndex = binarySearch(nums, index + 1, nums.length - 1, nums[index]);
            swap(nums, index, swapIndex);
        }
        reverse(nums, index + 1);
        return;
    }

    private int binarySearch(int[] arr, int left, int right, int key) {
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(key >= arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return;
    }

    private void reverse(int[] arr, int index) {
        int endIndex = arr.length - 1;
        while(index < endIndex) {
            swap(arr, index, endIndex);
            index++;
            endIndex--;
        }
        return;
    }

    public static void main(String args[]) {
        NextPermutation obj = new NextPermutation();
        int[] nums = new int[] {2, 4 ,3, 1};
        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {4, 3 ,2, 1};
        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}