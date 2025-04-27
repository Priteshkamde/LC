class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        if(N < 0)
            return 0;
        if (N == 1)
            return nums[0];

        int currSum = 0;
        int max = nums[0];
        for(int i = 0 ; i < N; i++){
            currSum = currSum + nums[i];
            if(currSum > max) {
                max = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
    
        return max;
    }
}