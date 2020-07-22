public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ns1 = nums1.length, ns2 = nums2.length;
        int[] nums3 = new int[ns1 + ns2];
        int i = 0, j = 0, k = 0;
        // Merge arrays
        while(i < ns1 && j < ns2) {
            if(nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                k++; i++;
            }
            else {
                nums3[k] = nums2[j];
                k++; j++;
            }
        }
        while(i < ns1) {
            nums3[k] = nums1[i];
            k++; i++;
        }
        while(j < ns2) {
            nums3[k] = nums2[j];
            k++; j++;
        }
        // Find median
        if(nums3.length % 2 == 0) {
            return ((nums3[nums3.length/2 - 1] + nums3[nums3.length/2])/(double)2);
        }
        return (double)nums3[nums3.length/2];
    }
}