class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
    int maxRes = 0;

        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                maxRes = Math.max( maxArea(i,j, grid), maxRes);
            }
        }

        return maxRes;
    }

    public int maxArea(int row, int col, int[][] grid){

        // check boundary
        // mark land as water
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length 
        || grid[row][col] == 0) return 0;

        grid[row][col] = 0;
        
        return ( 1 + 
        maxArea(row+1, col, grid) +
        maxArea(row-1, col, grid) +
        maxArea(row, col+1, grid) +
        maxArea(row, col-1, grid)
        );
    }
}