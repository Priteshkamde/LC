class Solution {
    List<List<String>> result = null;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList();
        char[][] board = new char[n][n];
        // empty board
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j < n ; j ++)
                board[i][j] = '.';

        // queens
        List<int[]> queens = new ArrayList();
        // DFS
        // backtrack(start index, board[][], queens[])
        backtrack(0, board, queens);
        return result;
    }

    private void backtrack(int row, char[][] board, List<int[]> queens){
        // base case, no. of queens = n
        if(queens.size() == board.length){
            List<String> rows = new ArrayList();
            for(char[] r : board)
                rows.add(new String(r));

            // result
            result.add(rows);
            return;
        }

        // try to add Queen
        for(int col = 0 ; col < board.length ; col++) {
            if(isSafe(row,col,queens)){
                board[row][col] = 'Q';
                queens.add(new int[]{row,col});
                backtrack(row+1, board, queens);
                // reset
                board[row][col] = '.';
                queens.remove(queens.size()-1);
            }
        }
    }

    private boolean isSafe(int row, int col, List<int[]> queens){
        for(int[] current : queens) {
            int dx = Math.abs(row - current[0]);
            int dy = Math.abs(col - current[1]);
            if(dx == 0 || dy == 0 || dx == dy)
                return false;
        }

        return true;
    }
}