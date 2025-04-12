class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    
            // [1,2,3,4,5,6,7]
            
            // appply reverse on complete array
            // appply reverse from 0th -> k
            // appply reverse from k+1 -> len -1
            //  7 6 5 4 3 2 1
}
    
    public void reverse( int[] nums, int start, int end) {
        
        while(start<end) {
            
            swap(nums, start++, end--);
            
        }
        
    System.out.print(Arrays.toString(nums));
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}