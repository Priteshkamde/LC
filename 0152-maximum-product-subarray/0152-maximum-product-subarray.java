class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)    
            return 0;

        if(nums.length == 1)
            return nums[0];

        int N = nums.length;

        int leftProduct = 1;
        int rightProduct = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++) {
            if(leftProduct == 0) 
                leftProduct = 1;
            if(rightProduct == 0) 
                rightProduct = 1;
                
            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[N-1-i];
            max = Math.max(max, Math.max(leftProduct, rightProduct));
        }

        return max;
    }
}