class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length == k) return nums;

        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>
                        (k, (a,b) -> map.get(a)-map.get(b));

        for(int key : map.keySet()) {
            q.add(key);
            if (q.size() > k) {
                q.poll();
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            result[index++] = q.poll();
        }

        return result;
    }
}