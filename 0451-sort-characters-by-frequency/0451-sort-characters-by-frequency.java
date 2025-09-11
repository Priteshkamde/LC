class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        ); 

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : map.keySet())
            pq.add(c);

        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);
            sb.repeat(ch,freq);
        }

        return sb.toString();
    }
}