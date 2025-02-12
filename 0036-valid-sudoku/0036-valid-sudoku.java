class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet();

        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                if(board[i][j] != '.') {
                    if (!set.add(board[i][j] + " in row " + i) ||
                        !set.add(board[i][j] + " in col " + j) ||
                        !set.add(board[i][j] + " in box " + (i / 3) + "-" + (j / 3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}