package Grind75;

import java.util.LinkedList;
import java.util.Queue;

public class _41_RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int initRotten = 0;
        int nextRotten = 0;
        int countFreshFruits = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                    initRotten++;
                }
                if(grid[i][j] == 1) {
                    countFreshFruits++;
                }
            }
        }
        int minutes = 0;
        while(!queue.isEmpty()) {
            if(initRotten == 0) {
                minutes++;
                initRotten = nextRotten;
                nextRotten = 0;
            }
            int[] rotten = queue.poll();
            int x = rotten[0];
            int y = rotten[1];
            initRotten--;
            if(x - 1 >= 0 && grid[x - 1][y] == 1) {
                grid[x - 1][y] = 2;
                queue.offer(new int[] {x - 1, y});
                nextRotten++;
                countFreshFruits--;
            } if(x + 1 < grid.length && grid[x + 1][y] == 1) {
                grid[x + 1][y] = 2;
                queue.offer(new int[] {x + 1, y});
                nextRotten++;
                countFreshFruits--;
            } if(y - 1 >= 0 && grid[x][y - 1] == 1) {
                grid[x][y - 1] = 2;
                queue.offer(new int[] {x, y - 1});
                nextRotten++;
                countFreshFruits--;
            } if(y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                grid[x][y + 1] = 2;
                queue.offer(new int[] {x, y + 1});
                nextRotten++;
                countFreshFruits--;
            }
        }
        if(countFreshFruits > 0) {
            return -1;
        }
        return minutes;
    }
}
