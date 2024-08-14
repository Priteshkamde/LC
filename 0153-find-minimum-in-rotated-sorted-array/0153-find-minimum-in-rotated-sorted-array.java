class Solution {
    public int findMin(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) 
            list.add(nums[i]);
        
        return Collections.min(list);
    }
}