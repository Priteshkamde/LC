class Solution {
    public int maxProfit(int[] prices) {
        
        int left = 0;
        int right = left+1;
        int curr_min = 0 ;
        int profit = 0;
        int curr_profit = 0;
        while(right < prices.length) {
            if(prices[left] < prices[right])
                profit = Math.max(prices[right] - prices[left], profit);
            else 
                left = right;
        right++;
        }
        return profit;
    }
}