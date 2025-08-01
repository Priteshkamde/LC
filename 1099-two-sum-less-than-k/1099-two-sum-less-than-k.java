class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        
        int low = 0;
        int high = nums.length-1;
        Arrays.sort(nums);
        int maxSum = -1;
        while(low < high) {
            int sum = nums[low] + nums[high];
            if(sum < k) {
                maxSum = Math.max(sum, maxSum);
                low++;
            } else {
                high--;
            }
        }

        return maxSum;
    }
}