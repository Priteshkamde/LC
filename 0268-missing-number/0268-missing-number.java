class Solution {
    public int missingNumber(int[] nums) {
        int currSum = 0 ;
        for(int x : nums) currSum+=x;

        int rangeSum = 0;
        for(int i = 0 ; i <= nums.length ; i++) {
            rangeSum += i;
        }

        return rangeSum - currSum;
    }
}