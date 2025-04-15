class Solution {
    public void moveZeroes(int[] nums) {
        
        int N = nums.length;
        int left = 0;
        int right = left+1;
        while(right < N) {
            if(nums[right] != 0) {
                int goLeft = right;
                right += 1;
                while(goLeft > 0 && nums[goLeft-1] == 0) {
                    nums[goLeft-1] = nums[goLeft];
                    nums[goLeft] = 0;
                    goLeft-=1;
                }
            } else {
                right+=1;
            }
        }

        while(right<N) {
            nums[right] = 0;
            right++;
        }
    }
}