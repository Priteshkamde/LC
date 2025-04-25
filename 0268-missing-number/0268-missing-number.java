class Solution {
    public int missingNumber(int[] nums) {
        int rangeTotal = 0;
        int currTotal = 0;
        for(int x : nums) {
            currTotal += x; 
        }

        for(int i = 0 ; i <= nums.length ; i++) {
            rangeTotal += i;
        }

        return rangeTotal - currTotal;
    }
}