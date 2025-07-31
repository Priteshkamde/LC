class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> map.get(b) - map.get(a)
        );

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()) {
            pq.add(key);
        }

        int[] result = new int[k];
        int index = 0;
        while(!pq.isEmpty() && k-- > 0) {
            result[index++] = pq.poll();
        }

        return result;
    }
}