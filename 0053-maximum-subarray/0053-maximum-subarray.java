class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        if(N < 0)
            return 0;
        if (N == 1)
            return nums[0];

        int currSum = nums[0];
        int max = nums[0];
        for(int i = 1 ; i < N; i++){
            currSum = Math.max(nums[i], nums[i] + currSum);
            max = Math.max(max, currSum);
        }
    
        return max;
    }
}