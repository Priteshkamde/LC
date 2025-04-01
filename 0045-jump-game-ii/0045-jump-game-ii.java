class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        int jumps = 0;
        int end = 0;
        int farthest = 0;
        for (int i = 0; i < N-1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if(i == end) {
                jumps++;
                end = farthest;
            }
        }

        return jumps;

    }
}