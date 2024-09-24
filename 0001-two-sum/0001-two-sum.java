class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int find = 0;
        for ( int i = 0 ; i < nums.length; i++ ){
            find = target - nums[i];
            if(hm.containsKey(find)){
                return new int[]{hm.get(find), i};
            } else {
                hm.put(nums[i], i);
            }
        }

        return new int[]{-1};
    }
}