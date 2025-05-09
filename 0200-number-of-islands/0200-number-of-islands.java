class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int islands = 0;
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col ; j++) {
                if( grid[i][j] == '1') {
                    dfs(i,j,row, col, grid, visited);
                    islands+=1;
                }
            }
        }

        return islands;
    }

    void dfs(int i,int j,int row, int col, char[][] grid, boolean[][] visited) {

        if(i<0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i+1, j, row, col, grid, visited);
        dfs(i-1, j, row, col, grid, visited);
        dfs(i, j+1, row, col, grid, visited);
        dfs(i, j-1, row, col, grid, visited);
    }
}