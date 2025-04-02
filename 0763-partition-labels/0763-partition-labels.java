class Solution {
    public List<Integer> partitionLabels(String s) {
        // same as overlapping and merging intervals
        List<int[]> intervals = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for(char x : s.toCharArray())
            set.add(x);

        for (Character st : set) 
            intervals.add(new int[] { s.indexOf(st), s.lastIndexOf(st) });

        Collections.sort(intervals, (a,b) -> a[0]-b[0]);
        
        List<int[]> list = new LinkedList<>();
        int[] current = intervals.get(0);
        for(int i = 0; i < intervals.size() ; i++) {
            int[] next = intervals.get(i);

            if(current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                list.add(current);
                current = next;
            }
        }
        list.add(current);

        List<Integer> result = new ArrayList();
        for(int[] i : list) {
            result.add(i[1]-i[0]+1);
        }

        return result;
    }
}