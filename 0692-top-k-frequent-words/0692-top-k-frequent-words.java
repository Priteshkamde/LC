class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words) {
            map.put(word, map.getOrDefault(word,0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) ? 
            b.compareTo(a) : map.get(a) - map.get(b)
        );

        for(String s : map.keySet()) {
            pq.add(s);
            if(pq.size() > k) 
                pq.poll();
        }

        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);

        return result;
    }
}