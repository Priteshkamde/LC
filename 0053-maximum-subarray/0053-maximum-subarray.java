class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) 
            return nums[0];

        int[] temp = new int[nums.length];
        
        temp[0] = nums[0];
        int res = 0;
        for(int i = 1 ; i < nums.length ; i++){
            temp[i] = Math.max(temp[i-1]+nums[i], nums[i]);
        }
        
        int max = temp[0];
        for(int x : temp) {
            if(x>max) {
                max = x;
            }
        }

        return max;
    }
}