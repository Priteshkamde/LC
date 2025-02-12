class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) 
            return 0;  
        
        int maxLen = 1;
        int currMax = 1;
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length-1 ; i++) {
            if(nums[i] == nums[i+1]) {
                continue;
            }
            if(Math.abs(nums[i]-nums[i+1]) == 1) {
                currMax+=1;
                maxLen = Math.max(maxLen, currMax);
            } else {
                currMax = 1;
            }
        }

        return maxLen;
    }
}