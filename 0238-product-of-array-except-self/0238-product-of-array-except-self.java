class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int prefix = 1;
        int suffix = 1;

        int[] ans = new int[N];
        
        for(int i = 0 ; i < N ; i++) {
            ans[i] = prefix;
            prefix = prefix * nums[i];    
        }

        for(int i = N-1 ; i >= 0 ; i--) {
            ans[i] = suffix * ans[i];
            suffix = suffix * nums[i];    
        }

        return ans;
        
    }
}