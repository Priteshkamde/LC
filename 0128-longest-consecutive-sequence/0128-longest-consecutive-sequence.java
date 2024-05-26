
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Arrays.sort(nums);

        int max = 1;
        int currMax = 1;

        for (int i = 1; i < nums.length; i++) {
            // Check if the current number is the same as the previous number (duplicate)
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Check if the current number is consecutive to the previous number
            if (nums[i] == nums[i - 1] + 1) {
                currMax++;
            } else {
                currMax = 1;
            }
            
            // Update the max length of consecutive sequence
            max = Math.max(max, currMax);
        }

        return max;
    }
}
