class Solution {
    public int findKthLargest(int[] nums, int k) {

        // use a Priority Queue
        // ensure that size is k
        // pop the last
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x : nums) {
            pq.add(x);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}