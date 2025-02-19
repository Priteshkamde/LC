class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
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
                tempResult.add(nums[i]);
                backtrack(result, tempResult, nums, target - nums[i], i);
                tempResult.remove(tempResult.size() - 1);
            }
        }
}