class Solution {
    public int maximumCount(int[] nums) {
        int N = nums.length;
        int low = 0;
        int high = N -1;

        // find min positive
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(nums[mid] > 0) {
                high = mid-1;
            }
            else{
                low = mid+1;   
            }
        }
        // output is index left
        int posCount = N - low;

        // max negative
        low = 0;
        high = N-1;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(nums[mid] < 0) {
                low = mid+1;
            }
            else{
                high = mid-1;   
            }
        }

        int negCount = high+1;

        return Math.max(posCount, negCount);
    }
}