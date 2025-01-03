package Grind75;

public class _36_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int numCoins = recurse(coins, amount, dp);
        return numCoins;
    }

    private int recurse(int[] coins, int amount, int[] dp) {
        if(amount == 0) {
            return 0;
        } else if(amount < 0) {
            return -1;
        } else if(dp[amount] != 0) {
            return dp[amount];
        }
        int numCoins = Integer.MAX_VALUE;
        for(int coin: coins) {
            int temp = recurse(coins, amount - coin, dp);
            if(temp >= 0) {
                temp++;
                numCoins = Math.min(numCoins, temp);
            }
        }
        dp[amount] = numCoins == Integer.MAX_VALUE ? -1 : numCoins;
        return dp[amount];
    }

    public static void main(String[] args) {
        _36_CoinChange obj = new _36_CoinChange();
        System.out.println(obj.coinChange(new int[] {1,2,3}, 5));
    }
}
