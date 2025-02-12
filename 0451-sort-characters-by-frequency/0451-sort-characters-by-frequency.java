class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue(
            (a,b) -> map.get(b) - map.get(a)
        );

        for(char c : map.keySet()) {
            pq.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Character c  = pq.poll();
            int count = map.get(c);
            while(count > 0) {
                sb.append(c);
                count--;
            }
        }

        return sb.toString();        
    }
}