class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0; 
        
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
             
                max = Math.max(max, dfs(grid, i, j));
                
            }
        }
        
        return max;
        
    }
    
    
    public int dfs(int grid[][], int row, int col){
        
        if(row < 0 || row >= grid.length 
          || col < 0 || col >= grid[row].length || grid[row][col]==0 ) {
            return 0;
        }
        
        grid[row][col] =0;
        int count = 1;
        count += dfs(grid, row+1, col);
        count += dfs(grid, row-1, col);
        count += dfs(grid, row, col+1);
        count += dfs(grid, row, col-1);

        return count;
    }
    
}