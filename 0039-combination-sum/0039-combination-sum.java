class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, result, new ArrayList());
        return result;
    }
    private void backtrack(int[] candidates, int target, int start, 
    List<List<Integer>> result, List<Integer> temp){

        if(target == 0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        if(target < 0)
            return;
        
        for(int i = start ; i < candidates.length ; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i, result, temp);
            temp.remove(temp.size()-1);
        }

    }
}