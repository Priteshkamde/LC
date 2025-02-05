class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();
        if( sum %2 != 0) 
            return false;

        int index = 0;
        return helperSum(nums, index, sum/2);
    }

    Map<String, Boolean> map = new HashMap();

    private boolean helperSum(int[] nums, int index, int currSum) {

        if(currSum == 0) 
            return true;
        if(currSum < 0) 
            return false;
        if(index >= nums.length)
            return false;

        String key = currSum + "-" + index;

        if(!map.containsKey(key)) 
        map.put(key, 
        helperSum(nums, index+1, currSum - nums[index]) || 
        helperSum(nums, index+1, currSum));

        return map.get(key);
    }
}