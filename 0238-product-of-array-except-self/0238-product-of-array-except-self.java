class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int prefix[] = new int[N];
        int suffix[] = new int[N];
        
        prefix[0] = 1;
        suffix[N-1] = 1;

        for(int i = 1 ; i < nums.length ; i++)
            prefix[i] = nums[i-1] * prefix[i-1];
        
        for(int i = N-2 ; i >= 0 ; i--)
            suffix[i] = nums[i+1] * suffix[i+1];
        
        for(int i = 0 ; i < nums.length ; i++)
            nums[i] = prefix[i] * suffix[i];
            
        return nums;
    }
}