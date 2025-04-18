class Solution {
    public int maximumCount(int[] nums) {
        int ptr = 0;
        int left = 0;
        int negCount = 0;
        int posCount = 0;
        int N = nums.length;

        while(ptr < N && nums[ptr] < 0) {
            ptr++;
            negCount++;
        }

        while(ptr < N && nums[ptr] == 0) {
            ptr++;
        }

        while(ptr < N && nums[ptr] > 0) {
            posCount++;
            ptr++;
        }

        return Math.max(posCount, negCount);
    }
}