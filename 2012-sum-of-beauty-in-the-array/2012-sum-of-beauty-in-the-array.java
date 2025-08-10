class Solution {
    public int sumOfBeauties(int[] nums) {
        int N = nums.length;
        int[] prefixMax = new int[N];
        int[] suffixMin = new int[N];

        prefixMax[0] = nums[0];
        for(int i = 1; i < N ; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
        }
        
        suffixMin[N-1] = nums[N-1];
        for(int i = N-2; i >= 0 ; i--) {
            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
        }

        int sum = 0;
        for(int i = 1; i < N - 1 ; i++) {
            if(prefixMax[i-1] < nums[i] && nums[i] < suffixMin[i+1])
                sum+=2;
            else if(nums[i-1] < nums[i] && nums[i] < nums[i+1])
                sum+=1;
        }

        return sum;
    }
}