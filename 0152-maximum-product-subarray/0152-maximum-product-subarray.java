class Solution {
    public int maxProduct(int[] nums) {

        int leftP = 1;
        int rightP = 1;
        int maxProd = nums[0];

        for(int i = 0 ; i < nums.length; i++) {

            if(leftP == 0)
                leftP = 1;
            if(rightP == 0)
                rightP = 1;
        
            leftP *= nums[i];
            rightP *= nums[nums.length - i - 1];

            maxProd = Math.max(maxProd, Math.max(leftP, rightP));
        } 

        return maxProd;

    }
}