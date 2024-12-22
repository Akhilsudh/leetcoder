package Grind75;

public class _4_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buyValue = Integer.MAX_VALUE;
        int sellValue = Integer.MIN_VALUE;
        int profit = 0;
        for(int i: prices) {
            if(buyValue > i) {
                buyValue = i;
                sellValue = Integer.MIN_VALUE;
            } else if(sellValue < i) {
                sellValue = i;
            }
            if(buyValue != Integer.MAX_VALUE && sellValue != Integer.MIN_VALUE) {
                profit = Math.max(sellValue - buyValue, profit);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        _4_BestTimeToBuyAndSellStock obj = new _4_BestTimeToBuyAndSellStock();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(obj.maxProfit(new int[] {2,4,1}));
    }
}
