class Solution {

    private boolean dfs(int node, int[] visited, int[] recStack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;  // Mark node as visited
        recStack[node] = 1; // Add to recursion stack

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) { 
                // If not visited, continue DFS
                if (dfs(neighbor, visited, recStack, adj)) {
                    return true; // Cycle found
                }
            } else if (recStack[neighbor] == 1) {
                // If neighbor is in recStack, a cycle exists
                return true;
            }
        }

        recStack[node] = 0; // Remove from recursion stack
        return false;       // No cycle found
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = numCourses;

        // Adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
        }

        // Visited and recursion stack arrays
        int[] visited = new int[N];
        int[] recStack = new int[N];

        // Perform DFS for every unvisited node
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (dfs(i, visited, recStack, adj)) {
                    return false; // Cycle detected, cannot finish all courses
                }
            }
        }

        return true; // No cycles detected, all courses can be finished
    }
}
