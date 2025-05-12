class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // hashmap = <key, value>
        // treemap <key, List>
        // in treemap where key is frequency i.e. value in hashmap
        // in the treemap sorted by natural orderin
        // extract from last of tree map
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        TreeMap<Integer, List<Integer>> treemap= new TreeMap<>();

        for(int num : map.keySet()) {
            int freq = map.get(num);
            if(!treemap.containsKey(freq)){
                treemap.put(freq, new LinkedList());
            }
            treemap.get(freq).add(num);
        }

        // <1, <3,4>>
        // <3, <1,2>>

        int index = 0;
        int[] result = new int[k];
        while(index < k) {
            Map.Entry<Integer, List<Integer>> entry= treemap.pollLastEntry();
            List<Integer> list = entry.getValue();
            for(int x : list) {
                result[index++] = x;
            }
        }

        return result;
    }
}