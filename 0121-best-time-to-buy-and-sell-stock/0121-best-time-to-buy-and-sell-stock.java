class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;

        if(prices.length == 1)
            return 0;

        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0 ; i < prices.length ; i++) {
            minValue = Math.min(minValue, prices[i]);

            if(prices[i] > minValue) {
                maxProfit = Math.max(prices[i]-minValue, maxProfit);
            }
        }

        return maxProfit;
    }
}