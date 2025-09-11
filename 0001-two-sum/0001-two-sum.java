class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length ; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            } else {
                map.put(nums[i], i);
            } 
        }

        return new int[]{-1,-1};

        // 
        // A = 2
        // B = ? 
        // look for total - A if you have 
        // if yes then return index 
        // iterate 
        // get element from nums
        // 

    // int[] res = new int[2];
    // HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    //  for(int i = 0 ; i < nums.length; i++) {

    //      int B = target - nums[i];
    //      if(hm.containsKey(B)) {
    //         res[0] = i;
    //         res[1] = hm.get(B);
    //         break;
    //      } else {
    //          hm.put(nums[i], i);
    //      }
    //  }

    //  return res;

        
    }
}