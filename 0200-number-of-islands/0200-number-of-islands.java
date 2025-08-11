class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0; j< cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j, rows, cols, grid);
                    islands+=1;
                }  
            }
        }

        return islands;
    }

    private void dfs(int i, int j, int rows, int cols, char[][] grid) {

        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';

        dfs(i+1, j, rows, cols, grid);
        dfs(i, j+1, rows, cols, grid);
        dfs(i-1, j, rows, cols, grid);
        dfs(i, j-1, rows, cols, grid);
    }
}