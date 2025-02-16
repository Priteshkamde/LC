class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 
        int N = nums.length;
        // use Deque to store index of nums elements
        Deque<Integer> q = new ArrayDeque<Integer>();
        int[] result = new int[N-k+1];
        int index = 0;

        for(int i = 0 ; i < N ; i++) {

            // for each iteration check and remove for out of range k
            if(!q.isEmpty() && q.peek() == i-k) {
                // removes from front
                q.poll();
            }

            // remove small elements from rear
            // if we find a greater element in array than 
            // the ones in the q rear
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            // always add to q
            q.offer(i);

            // extract 
            if( i >= k-1){
                result[index++] = nums[q.peek()];
            }
        }
        return result;
    }
}