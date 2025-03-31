class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length+1][2];

        int i = 0;
        int j = 0;
        // no overlap - simply add them
        while(j < intervals.length && intervals[i][1] < newInterval[0]){
            result[j++] = intervals[i];
            i++;
        }
        // overlap present - start merging
        while(i < intervals.length && newInterval[0] <= intervals[i][1]
        && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }

        result[j++] = newInterval;

        while(i < intervals.length) {
            result[j++] = intervals[i];
            i++;
        }

        return Arrays.copyOf(result, j);
    }
}