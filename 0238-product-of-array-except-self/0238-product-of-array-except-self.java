class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] prefix = new int[N];
        int[] suffix = new int[N];
        prefix[0] = 1;
        suffix[N-1] = 1;

        for(int i = 1 ; i < N; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i = N-2 ; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] result = new int[N];
        for(int i = 0 ; i < N ; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}