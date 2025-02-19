class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    public void backtrack(
        List<List<Integer>> result, 
        List<Integer> tempResult, 
        int[] nums, 
        int target, int start) {

        if(target == 0) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        if(target < 0) return;

        for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates

                tempResult.add(nums[i]);
                backtrack(result, tempResult, nums, target - nums[i], i+1);
                tempResult.remove(tempResult.size() - 1);
            }
        }
}