class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

        private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){

        
        if(!result.contains(new ArrayList(temp)))
            result.add(new ArrayList(temp));

        for(int i = start ; i < nums.length ; i++) {
            // decision 1 = include number
            if( i < start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);

            // recur = perform a recursion 
            backtrack(result, temp, nums, i+1);

            // diff decision = no need to pick that number in next iteration
            temp.remove(temp.size()-1);
        }

    }
}