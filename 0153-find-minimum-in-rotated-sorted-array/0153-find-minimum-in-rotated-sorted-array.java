class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 1) return nums[0];

        int low = 0 ; 
        int high = nums.length-1;
        int result = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = (low+high)/2;
            // sorted
            if(nums[low] < nums[high]) {
                result = Math.min(result, nums[low]);
                break;
            }

            if(nums[low] <= nums[mid]){
                result = Math.min(result, nums[low]);
                low = mid + 1;
            }
            else {
                result = Math.min(result, nums[mid]);
                high = mid-1;
            }
        }

        return result;
    }
}