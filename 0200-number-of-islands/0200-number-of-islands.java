class Solution {
    public int numIslands(char[][] grid) {
        
        
        int islands = 0;
        
        // edge case
        if(grid.length == 0 || grid == null) return 0;
        
        
        // iterate thru the matrix
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                // 1 is island found, only then perform bfs
                if(grid[i][j] == '1') {
                    islands+=1;
                    callBFS(grid, i , j);
                }
            }
        }
        
        return islands;
    }
    
    public void callBFS(char[][] grid, int i , int j){
        
        // base case
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
        return ;
        
        grid[i][j] = '0';
        callBFS(grid, i+1 , j); // right
        callBFS(grid, i-1 , j); // left
        callBFS(grid, i , j+1); // below
        callBFS(grid, i , j-1); // above
    }
}