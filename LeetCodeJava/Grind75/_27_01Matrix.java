// BFS
package Grind75;

import java.util.*;

public class _27_01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[] {i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[] dir = {-1, 1, 0, 0};
        while(!queue.isEmpty()) {
            int[] coord = queue.remove();
            for(int i = 0; i < 4; i++) {
                int y = coord[0] + dir[i];
                int x = coord[1] + dir[3 - i];
                if(y < 0 || y >= mat.length || x < 0 || x >= mat[0].length || mat[y][x] != -1) {
                    continue;
                }
                mat[y][x] = mat[coord[0]][coord[1]] + 1;
                queue.offer(new int[]{y, x});
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        _27_01Matrix obj = new _27_01Matrix();
    }
}
