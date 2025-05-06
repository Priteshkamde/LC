class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < numCourses ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int edge : adj.get(i)) {
                indegree[edge]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> toposort = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int node = q.poll();
            toposort.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }


        return toposort.size() == numCourses;

    }
}