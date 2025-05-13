class Solution {
    public int findShortestSubArray(int[] nums) {
        List<Integer> maxAppears = new ArrayList<Integer>();

        HashMap<Integer, Integer> map = new HashMap<>();

        int maxFreq = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        for(int key : map.keySet()) {
            if(map.get(key) == maxFreq) {
                maxAppears.add(key);
            }
        }

        int minRange = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        for(int element : maxAppears) {
            start = -1;
            end = -1;
            for(int i = 0 ; i < nums.length ; i++) {
                if(nums[i] == element) {
                    if(start == -1)
                        start = i;
                    end = i;
                }
            }
            minRange = Math.min(minRange, end-start+1);
        }

        return minRange;
    }
}