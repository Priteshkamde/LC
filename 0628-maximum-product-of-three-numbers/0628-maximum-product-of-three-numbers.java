class Solution {
    public int maximumProduct(int[] nums) {
        
        // get the minimum of 2 & max
        // get the max 3
        Arrays.sort(nums);

        int a = nums[0] * nums[1] * nums[nums.length-1];
        int b = nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1];

        return Math.max(a,b);
        
    }
}