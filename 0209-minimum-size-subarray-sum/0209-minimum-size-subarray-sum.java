class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for(int right = 0; right < nums.length; right++) {

            sum += nums[right];
            // build the sum

            while(sum >= target) {
                minLen = Math.min(minLen, right-left+1);
                // shrink from LEFT hand side - reduce the window
                // by incrementing left pointer and reducing the sum untill target
                sum -= nums[left];
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}