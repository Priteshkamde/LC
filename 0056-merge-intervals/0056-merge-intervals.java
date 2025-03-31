class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        List<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] current = intervals[0];
        for(int i = 0; i < intervals.length ; i++) {
            int[] next = intervals[i];

            if(current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                list.add(current);
                current = next;
            }
        }
        list.add(current);

        return list.toArray(new int[list.size()][2]);
    }
}