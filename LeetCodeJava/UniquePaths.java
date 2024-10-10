public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return dynamic(m - 1, n - 1, m, n, dp);
    }

    private int dynamic(int i, int j, int m, int n, int[][] dp) {
        if(i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j] > 0) {
            return dp[i][j];
        }
        if(i == 0 && j == 0) {
            dp[i][j] = 1;
            return 1;
        }
        int top = dynamic(i - 1, j, m, n, dp);
        int left = dynamic(i, j - 1, m, n, dp);
        dp[i][j] = top + left;
        return dp[i][j];
    }

    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        System.out.println(obj.uniquePaths(3, 2));
        System.out.println(obj.uniquePaths(3, 7));
        System.out.println(obj.uniquePaths(23, 12));
    }
}
