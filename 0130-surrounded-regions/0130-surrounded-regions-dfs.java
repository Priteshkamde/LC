class Solution {

    public void dfs(int row, int col, char[][] board, int[][] vis){

        vis[row][col] = 1;
        int[][] directions = {{1,0},{-1,0},{0,1},{0, -1}};

        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                && vis[newRow][newCol] == 0 && board[newRow][newCol] == 'O')
                dfs(newRow, newCol, board, vis);
        }
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] vis = new int[rows][cols];

        for(int j = 0 ; j < cols ; j++) {
            // first row
            if(board[0][j] == 'O' && vis[0][j] == 0)
                dfs(0, j, board, vis);
            // last row
            if(board[rows-1][j] == 'O' && vis[rows-1][j] == 0)
                dfs(rows-1, j, board, vis);
        }
        for(int i = 0 ; i < rows ; i++) {
            // first col
            if(board[i][0] == 'O' && vis[i][0] == 0)
                dfs(i, 0, board, vis);
            // last col
            if(board[i][cols-1] == 'O' && vis[i][cols-1] == 0)
                dfs(i, cols-1, board, vis);
        }

        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j< cols ; j++) {
                if(vis[i][j] == 0 && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}