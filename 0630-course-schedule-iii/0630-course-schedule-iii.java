class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a,b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        int time = 0 ;

        for(int[] course : courses) {

            if(course[0] + time <= course[1]) {
                time += course[0];
                pq.offer(course[0]);
            }
            else if( pq.size() > 0 && pq.peek() > course[0] ) {
                time -= pq.poll();
                time += course[0];
                pq.offer(course[0]);
            }
        }

        return pq.size();

    }
}