class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hash map to store freq
        // I will extract the value and act it as key for TreeMap
        // iterate in the tree map for K

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (!treeMap.containsKey(freq)) {
                treeMap.put(freq, new LinkedList<>());
            }
            treeMap.get(freq).add(key);
        }

        int index = 0;
        int[] result = new int[k];

        while (index < k) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            List<Integer> list = entry.getValue();

            for (int x : list) {
                result[index++] = x;
            }
        }

        return result;
    }
}