class Solution {
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        
        for(int i = 0 ; i < N ; i++)
            nums[i] = nums[i]*nums[i];

        Arrays.sort(nums);
        return nums;
    }
}