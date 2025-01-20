class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        for(int s : stones){
            pq.add(s);
        }
        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            if(x == y)
                continue;
            if(x > y)
                pq.add(x-y);
        }

        if(pq.size() == 0) return 0;
        else return pq.poll();
    }
}