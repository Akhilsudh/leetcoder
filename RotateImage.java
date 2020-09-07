import java.util.*;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int[] stack = new int[matrix.length * matrix.length];
        int top = -1;
        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = 0; j < matrix.length; j++) {
                stack[++top] = matrix[j][i];
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[i][j] = stack[top--];
            }
        }
    }

    public static void main(String args[]) {
        int [][] test1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotate(test1);
        System.out.println(Arrays.deepToString(test1));
        int [][] test2 = {
            {1, 2},
            {3, 4}
        };
        rotate(test2);
        System.out.println(Arrays.deepToString(test2));
    }
}