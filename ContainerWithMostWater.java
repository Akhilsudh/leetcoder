/*  https://leetcode.com/problems/container-with-most-water/
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
    n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find 
    two lines, which, together with the x-axis forms a container, such that the container contains the most water.
*/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int minIndex = 0;
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < j) {
            minIndex = (height[i] < height[j]) ? i : j;
            area = height[minIndex] * (j - i);
            maxArea = Math.max(area, maxArea);
            if(minIndex == i) {
                while(i < j) {
                    i++;
                    if(height[minIndex] < height[i]) {
                        break;
                    }
                }
            }
            else if(minIndex == j) {
                while(i < j) {
                    j--;
                    if(height[minIndex] < height[j]) {
                        break;
                    }
                }
            }

        }
        return maxArea;
    }
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println("The max area for [1,8,6,2,5,4,8,3,7] = " + obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println("The max area for [1,1] = " + obj.maxArea(new int[] {1,1}));
        System.out.println("The max area for [4,3,2,1,4] = " + obj.maxArea(new int[] {4,3,2,1,4}));
        System.out.println("The max area for [1,2,1] = " + obj.maxArea(new int[] {1,2,1}));
    }
}