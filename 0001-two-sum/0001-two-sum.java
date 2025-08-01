class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        

        for(int i = 0 ; i < nums.length ; i++) {
            int comple = target - nums[i];

            if(map.containsKey(comple)) {
                return new int[]{i, map.get(comple)};
            } 
            else {
                map.put(nums[i], i);
            }
        }

        return new int[]{0,0};

    }
}