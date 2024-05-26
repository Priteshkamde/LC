class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        
        int[] ans = new int[N];
        int prefix = 1;
        int suffix = 1;

        for(int i = 0 ; i < nums.length ; i++){
            ans[i] = prefix;
            prefix = prefix * nums[i];
        }
            
        for(int i = N-1 ; i >= 0 ; i--) {
            ans[i] = ans[i] * suffix;
            suffix = suffix * nums[i];
        }
        
        return ans;
    }
}