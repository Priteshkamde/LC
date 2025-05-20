class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums);

        return result;
    }

    void backtrack(List<List<Integer>>  result, ArrayList<Integer> tempList, int[] nums) {

        // base case
        if(tempList.size() == nums.length) {
            result.add(new ArrayList(tempList));
            return;
        }

        for(int num : nums) {
            if(tempList.contains(num))
                continue;
            tempList.add(num);
            backtrack(result, tempList, nums);
            tempList.remove(tempList.size()-1);
        }

    }
}