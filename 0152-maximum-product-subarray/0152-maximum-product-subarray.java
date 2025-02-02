class Solution {
    public int maxProduct(int[] nums) {

        // nums array
        // have a left ptr inc
        // right ptr dec
        // caulculate the product with the follwing
        // problem when we encounter a zero // we reset the curr product to 1

        int N = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int max = -99;
        for(int i = 0 ; i < N ; i++) {

            if(leftProduct == 0) leftProduct = 1;
            if(rightProduct == 0) rightProduct = 1;

            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[N-i-1];

            max = Math.max(max, Math.max(leftProduct, rightProduct));
        }
        return max;
    }
}