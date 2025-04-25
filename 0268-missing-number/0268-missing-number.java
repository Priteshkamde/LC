class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]>mid) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}