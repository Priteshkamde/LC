class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 1) return nums[0];
        
        int low = 0;
        int high = nums.length -1;
        int sol = Integer.MAX_VALUE;
        
        if(nums[low] < nums[high]) return nums[low];
        
        while(low <= high) {
             
            int mid = low + (high-low)/2;
            
            /// [4,5,6,7,0,1,2]
            
            if(nums[low] <= nums[mid]){
                sol = Math.min(sol, nums[low]);
                low = mid+1;
            }
            else {
                sol = Math.min(sol, nums[mid]);
                high = mid-1;
            }
            
        }
        
        return sol;
        
        
    }
}