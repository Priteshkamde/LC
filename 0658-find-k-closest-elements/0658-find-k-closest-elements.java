class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // int[] -> [dist, num]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
            if(a[0]!=b[0]) 
                return b[0] - a[0];// max heap for dist
        
            return b[1] - a[1]; //min heap for num
            }
        );


        for(int num : arr) {
            int dist = Math.abs(num-x);
            pq.add(new int[]{dist, num});

            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty())
            result.add(pq.poll()[1]);

        Collections.sort(result);

        return result;
    }
}   