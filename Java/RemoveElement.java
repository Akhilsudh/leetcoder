public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            if(nums[i] == nums[j] && nums[i] == val) {
                j--;
            }
            else if(nums[i] == val) {
                swap(i, j, nums);
                i++;
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println(i);
        return i;
    }
    
    private void swap(int index1, int index2, int[] arr) {
        if(index1 == index2) {
            return;
        }
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
        return;
    }
}
