class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = 0;
        int currSum = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            currSum = currSum + nums[i];

            if(currSum < 0) {
                currSum = 0;
            }
            if(currSum > max) {
                max = currSum;
            }
        }

        return max;
    }
}