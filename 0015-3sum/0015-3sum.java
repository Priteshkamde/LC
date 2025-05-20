class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();

        int N = nums.length;
        for(int i = 0 ; i < nums.length-2 ; i++) {

            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int left = i+1;
            int right = N-1;

            while(left < right) {
                
                int currSum = nums[i] + nums[left] + nums[right];

                if(currSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left < right && nums[right-1] == nums[right]) {
                        right--;
                    }

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