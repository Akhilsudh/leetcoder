public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int  m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return dynamic(m - 1, n - 1, dp, obstacleGrid);
    }

    private int dynamic(int i, int j, int[][] dp, int[][] grid) {
        if(i < 0 || j < 0) {
            return 0;
        } else if(grid[i][j] == 1){
            dp[i][j] = 0;
            return dp[i][j];
        } else if(dp[i][j] > 0) {
            return dp[i][j];
        } else if(i == 0 && j == 0) {
            dp[i][j] = 1;
            return dp[i][j];
        }
        int top = dynamic(i - 1, j, dp, grid);
        int left = dynamic(i, j - 1, dp, grid);
        dp[i][j] = top + left;
        return dp[i][j];
    }

    public static void main(String[] args) {
        UniquePathsII obj = new UniquePathsII();
        System.out.println(obj.uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(obj.uniquePathsWithObstacles(new int[][] {{0,1},{0,0}}));
    }
}
