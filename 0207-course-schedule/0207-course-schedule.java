class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adj matrix
        // calculate indegree
        // select the indegree where it is zero, and add to queue
        // start with the queue
        // add to queue only if indegree is zero, means it fully explored
        // last check is numCourses size is same as Topo result

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 

        for(int i = 0 ; i < numCourses ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] preq : prerequisites) {
            adj.get(preq[1]).add(preq[0]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++) {
            for(int incoming : adj.get(i)) {
                indegree[incoming]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < indegree.length ; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            count+=1;

            for(int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }   

        return count == numCourses;
    }
}