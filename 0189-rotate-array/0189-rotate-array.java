class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        if(k > N)
            k = k % N;

        rot(nums, 0, N-1);
        rot(nums, 0, k-1);
        rot(nums, k, N-1);
    }

    void rot(int[] nums, int st, int end) {
        while(st < end) {
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;

            st++;
            end--;
        }
    }
}