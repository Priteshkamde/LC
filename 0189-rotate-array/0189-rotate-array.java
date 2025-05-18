class Solution {
    public void rotate(int[] nums, int k) {
        
        int N = nums.length;
        k = k % N;

        rev(nums,0,N-1);
        rev(nums,0,k-1);
        rev(nums,k,N-1);
    }

    void rev(int[] nums, int start, int end) {
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}