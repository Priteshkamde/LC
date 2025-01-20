class Solution {
    public int[][] kClosest(int[][] points, int k) {
    // heap max
    PriorityQueue<int[]> pq = new PriorityQueue<>( 
        (pointA,pointB)-> Double.compare(getDistance(pointA), getDistance(pointB))
        );

    for(int[] point : points)
        pq.add(point);

    int[][] res = new int[k][2];
    for(int i = 0 ; i < k ; i++)
        res[i] = pq.poll();
        
    return res;
    }

    // function to calculate dist
    // return dist
    public double getDistance(int[] point){
        return Math.sqrt( point[0]*point[0] + point[1]*point[1] );
    }

}