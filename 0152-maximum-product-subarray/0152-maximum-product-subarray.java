class Solution {
    public int maxProduct(int[] nums) {

        int maxPrefix = 1;
        int maxSuffix = 1;
        int max = Integer.MIN_VALUE;

        int N = nums.length;
        for(int i = 0 ; i < N ; i++){
            if(maxPrefix == 0) maxPrefix = 1;
            if(maxSuffix == 0) maxSuffix = 1;

            maxPrefix = maxPrefix * nums[i];
            maxSuffix = maxSuffix * nums[N-i-1];

            max = Math.max(max, Math.max(maxPrefix, maxSuffix));
        }

        return max;
    }
}