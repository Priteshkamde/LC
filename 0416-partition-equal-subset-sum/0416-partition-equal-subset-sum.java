class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();
        if( sum %2 != 0) 
            return false;

        int index = 0;
        return helperSum(nums, index, sum/2);
    }

    private boolean helperSum(int[] nums, int index, int currSum) {

        if(currSum == 0) 
            return true;
        if(currSum < 0) 
            return false;
        if(index >= nums.length)
            return false;

        return helperSum(nums, index+1, currSum - nums[index]) || 
        helperSum(nums, index+1, currSum);
    }
}