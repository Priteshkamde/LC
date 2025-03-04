class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // pre set with a higher amt 
        dp[0] = 0; // amt = 0

        // iterate thru 1 -> amount
        for (int i = 1; i <= amount; i++) {
            // iterate thru the coins
            for (int coin : coins) {
                // ensure the coin < the amount to be built
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount]; // -1 if no solution
    }
}
