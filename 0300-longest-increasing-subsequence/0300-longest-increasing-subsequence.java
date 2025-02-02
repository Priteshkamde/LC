class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];

        Arrays.fill(dp, 1); // since each number is itlself a subseq

        // i pointer which is ahead
        for(int i = 1 ; i < N ; i++){
            // j pointer which catches up with i
            for(int j = 0 ; j < i ; j++) {
                if(nums[j] < nums[i]) // increasing sequence found
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}