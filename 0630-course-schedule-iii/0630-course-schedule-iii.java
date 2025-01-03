class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        // max b element from [a,b] sort order
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);

        int currTime = 0;
        
        // iterate
        for(int[] course : courses){
           
                // see if course can be completed within its last day
                if(course[0] + currTime <= course[1]) {
                    pq.offer(course[0]);
                    currTime += course[0];
                } else {
            // check if to swap the biggest duration in our queue can be replaced by the new one
                    if(pq.size() > 0 && course[0] < pq.peek()) {
                        // remove the old biggest duration
                        currTime -= pq.poll();
                        // update time with the new biggest duration
                        currTime += course[0];
                        // add the new course to priority qqueue
                        pq.offer(course[0]);
                    }
                
            }
        }
        

        return pq.size();
    }
}