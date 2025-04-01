class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        int left = 0, right = 0;
        int jumps = 0;
        while(right < N-1) {
            int farthest = 0;
            for(int i = left ; i <= right ; i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            left = right+1;
            right = farthest;
            jumps++;
        }

        return jumps;

    }
}