package Grind75;

public class _8_Binary_Search {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length  -1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _8_Binary_Search obj = new _8_Binary_Search();
        System.out.println(obj.search(new int[] {-1,0,3,5,9,12}, 9));
        System.out.println(obj.search(new int[] {-1,0,3,5,9,12}, 2));
    }
}
