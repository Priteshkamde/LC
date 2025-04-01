class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (i > max)
                return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}