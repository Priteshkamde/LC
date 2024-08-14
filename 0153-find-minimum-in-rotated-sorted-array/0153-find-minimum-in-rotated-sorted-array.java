class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 1) return nums[0];
        
        int low = 0;
        int high= nums.length -1;
        
        while(low < high) {
            
            int mid = low + (high-low)/2;
            
            /// [4,5,6,7,0,1,2]
            
            if(nums[mid] > nums[high])
                low = mid+1;
            else
                high = mid;
            
        }
        
        return nums[low];
        
        
    }
}