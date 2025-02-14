class Solution {
    public int maxProfit(int[] prices) {
        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0; 

        for(int price : prices) {
            c1 = Math.min(c1, price);
            p1 = Math.max(p1, price-c1);
            c2 = Math.min(c2, price-p1);
            p2 = Math.max(p2, price-c2);
        }

        return p2;
    }
}