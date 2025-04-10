class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        int left = 0;
        int right = 0;

        for(int i = 0 ; i < nums.length - 2; i++) {
            if(i>0 && nums[i] == nums[i-1]) 
                continue;    
            left = i+1;
            right = N-1;
            while(left < right) {
                int currSum = nums[i]+nums[left]+nums[right];
                
                if(currSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if(currSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}