class Solution {
    public int majorityElement(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N/2];  
    }
}