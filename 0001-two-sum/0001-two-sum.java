class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if(null == nums || 0 == nums.length) {
            return new int[]{0,0};
        }
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i = 0 ; i < nums.length; i++) {
            
            if(hm.containsKey(target - nums[i])) {
                return new int[]{hm.get(target - nums[i]), i};
            }
            else {
                hm.put(nums[i], i);            
            }
        }
        
        
        return new int[]{0,0};
        
    }
}