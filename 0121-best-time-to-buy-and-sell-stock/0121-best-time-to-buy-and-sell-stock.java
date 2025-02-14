class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        int currProfit = 0;
        int i = 0;
        int j = 1;
        int minPrice = Integer.MAX_VALUE;
        while(i < j && j < prices.length) {
            minPrice = Math.min(minPrice, prices[i]);
            currProfit = prices[j] - minPrice;
            System.out.println("currProfit= " + currProfit);
            if(currProfit > profit) {
                profit = Math.max(profit, currProfit); 
            }
            i++;
            j++;
        }
        return profit;
    }
}