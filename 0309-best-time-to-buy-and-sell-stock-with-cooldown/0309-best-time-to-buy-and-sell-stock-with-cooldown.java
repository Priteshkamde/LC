class Solution {
    public int maxProfit(int[] prices) {
        
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;
        for(int price : prices) {
            int prevSold = sold;
            sold = held + price;
            held = Math.max(held, reset-price);
            reset = Math.max(reset, prevSold);
        }
        return Math.max(sold, reset);
    }
}