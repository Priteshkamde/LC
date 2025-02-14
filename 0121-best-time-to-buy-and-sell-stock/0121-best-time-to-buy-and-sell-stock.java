class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        int currProfit = 0;
        int i = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int j = 0; j < prices.length; j++) {
            minPrice = Math.min(minPrice, prices[j]);
            currProfit = prices[j] - minPrice;
            profit = Math.max(profit, currProfit); 
        }
        return profit;
    }
}