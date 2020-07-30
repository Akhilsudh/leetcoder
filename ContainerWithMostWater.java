public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int maxArea = 0;
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}