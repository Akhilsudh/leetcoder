package Grind75;

import java.util.LinkedList;
import java.util.Queue;

public class _40_NumberOfIslands {
    // DFS Solution
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i+1, j, grid, visited);
        dfs(i-1, j, grid, visited);
        dfs(i, j+1, grid, visited);
        dfs(i, j-1, grid, visited);
    }

    // BFS Solution
    public int numIslandsBFS(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfs = new LinkedList<>();
        int result = 0;
        int[] helper = {1, -1, 1, -1};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    result += 1;
                    bfs.offer(new int[] {i,j});
                    while(!bfs.isEmpty()) {
                        int[] point = bfs.poll();
                        int x = point[0];
                        int y = point[1];
                        visited[x][y] = true;
                        if(x - 1 >= 0 && grid[x - 1][y] == '1' && !visited[x - 1][y]) {
                            bfs.offer(new int[] {x - 1, y});
                        } if(x + 1 < grid.length && grid[x + 1][y] == '1' && !visited[x + 1][y]) {
                            bfs.offer(new int[] {x + 1, y});
                        } if(y - 1 >= 0 && grid[x][y - 1] == '1' && !visited[x][y - 1]) {
                            bfs.offer(new int[] {x, y - 1});
                        } if(y + 1 < grid[0].length && grid[x][y + 1] == '1' && !visited[x][y + 1]) {
                            bfs.offer(new int[] {x, y + 1});
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _40_NumberOfIslands obj = new _40_NumberOfIslands();
        System.out.println(obj.numIslands(new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
