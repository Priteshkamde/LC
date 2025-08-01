class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] preq : prerequisites) {
            adj.get(preq[1]).add(preq[0]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++) {
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < indegree.length ; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        int count = 0;
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            result.add(node);
            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] ==0 ) {
                    q.add(neighbor);
                }
            }
        }

        if (result.size() == numCourses) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = result.get(i);
            }
            return res;
        }
        return new int[]{};
    }
}