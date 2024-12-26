package Grind75;

import java.util.*;

public class _16_ClimbingStairs {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n, memo);
    }

    private int dp(int n, int[] memo) {
        if(n < 0) {
            return 0;
        }
        if(memo[n] != -1) {
            return memo[n];
        }
        if(n == 0) {
            return 1;
        }
        memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        _16_ClimbingStairs obj = new _16_ClimbingStairs();
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs(10));
    }
}
