class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0,-1);

        int N = nums.length;

        int counter = 0;
        int maxLen = 0;

        for(int i = 0 ; i < N ; i++) {
            if(nums[i] == 0) {
                counter -= 1;
            } else {
                counter += 1;
            }

            if(!map.containsKey(counter)) {
                map.put(counter,i);
            }

            maxLen = Math.max(maxLen, i-map.get(counter));
        }

        return maxLen;
    }
}