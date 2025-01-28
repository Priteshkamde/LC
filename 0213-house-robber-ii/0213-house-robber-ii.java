class Solution {
    public int rob(int[] nums) {

        int N = nums.length;

        if (N == 0) return 0;
        if (N == 1) return nums[0];  
        return Math.max(robRange(nums, 0, N - 2), robRange(nums, 1, N - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        if (start > end) return 0;

        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(nums[i] + prev2, prev1); 
            prev2 = prev1;  
            prev1 = current;
        }

        return prev1;
    }
}
