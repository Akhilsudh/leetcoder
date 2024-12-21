import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 1;
        for(int i = 0; i < numbers.length - 1; i++) {
            int fastPointer = i + 1;
            int diff = target - numbers[i];
            while(fastPointer < numbers.length && numbers[fastPointer] < diff) {
                fastPointer++;
            }
            if(fastPointer < numbers.length && numbers[fastPointer] == diff) {
                index2 = fastPointer + 1;
                index1 = i + 1;
                break;
            }
        }
        return new int[] {index1, index2};
    }

    public int[] twoSumNew(int[] numbers, int target) {
        int left=0, right=numbers.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(numbers[mid]<target/2) left=mid+1;
            else right=mid;
        }
        if(numbers[right]>target/2){
            right--;
            left--;
        }
        if(right==numbers.length-1) left--;
        else right++;
        while(left>=0 && right<numbers.length){
            if(numbers[left]+numbers[right]==target) return new int[]{left+1, right+1};
            else if(numbers[left]+numbers[right]<target) right++;
            else left--;
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted_167 obj = new TwoSumIIInputArrayIsSorted_167();
        int[] arr1 = obj.twoSum(new int[] {2,7,11,15}, 9);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = obj.twoSum(new int[] {2,3,4}, 6);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = obj.twoSum(new int[] {-1,0,1}, 1);
        System.out.println(Arrays.toString(arr3));
        System.out.println("I am done!");
    }
}
