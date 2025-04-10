class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        for(int i = 0 ; i < nums.length - 2; i++) {
            if(i>0 && nums[i] == nums[i-1]) 
                continue;    
            left = i+1;
            right = N-1;
            while(left < right) {
                int currSum = nums[i]+nums[left]+nums[right];
                
                if(currSum == target) {
                    return target;
                } else if(currSum < target) {
                    left++;
                } else {
                    right--;
                }
                int currDiff = Math.abs(target - currSum);
                if(currDiff < minDiff) {
                    closest = currSum;
                    minDiff = currDiff;
                }
            }
        }

        return closest;
    }
}