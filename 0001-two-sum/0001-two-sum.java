class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap();
        int N = nums.length;
        int complement = 0;

        for(int i = 0 ; i < N ; i++) {
            complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}