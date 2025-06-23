class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // <num, freq>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // max heap by freq
        PriorityQueue<Integer> pq = new 
            PriorityQueue<>(
                (a,b) ->
                    map.get(b) - map.get(a)
            );

        for(int key : map.keySet()){
            pq.offer(key);
        }

        int[] result = new int[k];
        int index = 0 ;
        while(k-- > 0) {
            result[index++] = pq.poll();
        }

        return result;
    }
}