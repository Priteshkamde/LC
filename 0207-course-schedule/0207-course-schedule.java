class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Use adjacency list to form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            // Initialize empty lists for each course
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list (b -> a means to take course a, you must take course b first)
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
        }

        // Create an indegree array with size equal to numCourses
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int node : adj.get(i)) {
                indegree[node]++;
            }
        }

        // Queue to hold courses with no prerequisites
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> toposort = new ArrayList<>();

        // Process the queue
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

        // If toposort contains all courses, then we can finish all courses
        return toposort.size() == numCourses;
    }
}
