class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int[] newInterval = intervals[0];
        result.add(intervals[0]);

        for(int[] interval : intervals) {
            // overlap
            if(interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } 
            // no overlap
            else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}