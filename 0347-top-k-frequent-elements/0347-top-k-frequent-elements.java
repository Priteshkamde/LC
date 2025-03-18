class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length == k) return nums;
        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap();
        for(int num : map.keySet()) {
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList());
            }
            freqMap.get(freq).add(num);
        }

        int index = 0;
        while(index < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            List<Integer> values = entry.getValue();
            for(int x : values)
                result[index++] = x;
        }

        return result;
    }
}