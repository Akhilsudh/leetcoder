package Grind75;

import java.util.Arrays;

public class _9_Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color) {
            floodFillHelper(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    private void floodFillHelper(int[][] image, int sr, int sc, int target, int color) {
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == target) {
            image[sr][sc] = color;
            floodFillHelper(image, sr-1, sc, target, color);
            floodFillHelper(image, sr+1, sc, target, color);
            floodFillHelper(image, sr, sc-1, target, color);
            floodFillHelper(image, sr, sc+1, target, color);
        }
    }

    public static void main(String[] args) {
        _9_Flood_Fill obj = new _9_Flood_Fill();
        System.out.println(Arrays.deepToString(obj.floodFill(new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(obj.floodFill(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}}, 0, 0, 1)));
        System.out.println(Arrays.deepToString(obj.floodFill(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}}, 0, 0, 0)));
    }
}
