package Grind75;

public class _42_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        boolean hasRotated = false;
        if(nums[0] > nums[nums.length - 1]) {
            int l = 0;
            int r = nums.length - 1;
            int pivot = 0;
            while(l <= r) {
                int m = (r + l) / 2;
                if(m == 0 && nums[m+1] < nums[m]) {
                    pivot = m;
                    break;
                } if(m == nums.length-1 && nums[m-1] < nums[m]) {
                    pivot = m;
                    break;
                }
                if(m > 0 && m < nums.length - 1 && nums[m-1] < nums[m] && nums[m+1] < nums[m])
                {
                    pivot = m;
                    break;
                }
                if(nums[nums.length - 1] < nums[m]) {
                    l = m+1;
                } else if(nums[nums.length - 1] > nums[m]) {
                    r = m-1;
                }
            }
            if(target <= nums[nums.length - 1]) {
                return binarySearch(nums, target, pivot+1, nums.length - 1);
            } else {
                return binarySearch(nums, target, 0, pivot);
            }
        } else {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        int result = -1;
        while(l <= r) {
            int m = (r + l) / 2;
            if(nums[m] == target) {
                result = m;
                break;
            } else if(nums[m] > target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        _42_SearchInRotatedSortedArray obj = new _42_SearchInRotatedSortedArray();
        System.out.println(obj.search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(obj.search(new int[] {4,5,1,2,3}, 1));
        System.out.println(obj.search(new int[] {3,1}, 0));
        System.out.println(obj.search(new int[] {3,5,1}, 5));
    }
}
