class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int N = edges.length;
        int[] parents = new int[N+1];

        // each node is a parent of itself in the beginning
        for(int i = 0 ; i < N ; i++) {
            parents[i] = i;
        }

        //iterate through the edges one by one
        for (int[] edge : edges) {
            if(find(edge[0], parents) == find(edge[1], parents))
                return edge;

            union(edge[0], edge[1], parents);
        }

        //placeholder return
        return null;

    }

    public void union(int a, int b, int[] parents) {
        int aRoot = find(a, parents);
        int bRoot = find(b, parents);
        
        if( aRoot != bRoot)
            parents[bRoot] = aRoot;
    }

    public int find(int node, int[] parents) {
        while(parents[node] != node)
            node = parents[node];
        return node;
    }

}