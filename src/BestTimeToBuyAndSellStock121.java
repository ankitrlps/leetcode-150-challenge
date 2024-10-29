public class BestTimeToBuyAndSellStock121 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int effectiveBuy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - effectiveBuy);
            effectiveBuy = Math.min(effectiveBuy, prices[i]);
        }
        return profit;
    }
    
    public static void main(String[] args) {
        
    }
}
