class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result; 
    }


    public void dfs(
        int[] nums, 
        int index,
        List<Integer> path,
        List<List<Integer>> result) {

            result.add(path);
            for(int i = index ; i < nums.length ; i++) {

                if(i>index && nums[i] == nums[i-1]) continue;
            
                List<Integer> cPath = new ArrayList<>(path);
                cPath.add(nums[i]);

                dfs(nums, i+1, cPath, result);
            }
        }
}