class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //put into map

        // Map<7,0>
        // Map<2,1>
        for(int i = 0; i < nums.length ; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{0,0};
    }
}