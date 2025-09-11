class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int maxLen = 1;
        int[] dp = new int[nums.length];

        dp[0] = 1;

        for(int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] +1;
            } else {
                dp[i] = 1;
            }
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }
}