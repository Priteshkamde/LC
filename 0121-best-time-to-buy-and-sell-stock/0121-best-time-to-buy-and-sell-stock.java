class Solution {
    public int maxProfit(int[] prices) {

        int best = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            // best will be max profit until now
            best = Math.max(best, price-minPrice);
            // find min price to get max profit
            minPrice = Math.min(minPrice, price);
        }
        return best;
    }
}