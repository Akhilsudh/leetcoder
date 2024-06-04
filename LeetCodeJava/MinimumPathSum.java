import java.util.Arrays;

/*
64. Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/description/

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 200
*/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] dparr: dp) {
            Arrays.fill(dparr, Integer.MAX_VALUE);
        }
        return helper(0, 0, dp, grid);
    }

    private int helper(int i, int j, int[][] dp, int[][] grid) {
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if(i == dp.length || j == dp[0].length) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int temp = helper(i + 1, j, dp, grid);
        int down = (temp == Integer.MAX_VALUE) ? Integer.MAX_VALUE : grid[i][j] + temp;
        temp = helper(i, j + 1, dp, grid);
        int right = (temp == Integer.MAX_VALUE) ? Integer.MAX_VALUE :grid[i][j] + temp;
        dp[i][j] = Math.min(right, down);
        return dp[i][j];
    }

    public static void main(String[] args) {
        MinimumPathSum obj = new MinimumPathSum();

        int[][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        int result = obj.minPathSum(grid1);
        assert result == 7 : "The answer is not = 7";

        int[][] grid2 = {{1,2,3},{4,5,6}};
        result = obj.minPathSum(grid2);
        assert result == 12 : "The answer is not = 12";

        int[][] grid3 = {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}};
        result = obj.minPathSum(grid3);
        assert result == 83 : "The answer is not = 83";
        System.out.println("All test cases have passed");
    }
}
