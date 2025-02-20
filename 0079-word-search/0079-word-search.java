class Solution {

    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        // backtrack DFS
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++) {
                if( word.charAt(0) == board[i][j] && searchWord(i,j,0,board,word))
                    return true;
            }
        }

        return false;
        
    }

    private boolean searchWord(int row, int col, int index, char[][] board, String word){
        if(index == word.length()) {
            return true;
        }

        if( row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
         word.charAt(index) != board[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        if(searchWord(row+1,col,index+1,board,word) ||
            searchWord(row-1,col,index+1,board,word) ||
            searchWord(row,col+1,index+1,board,word) ||
            searchWord(row,col-1,index+1,board,word)
        ) {
            return true;
        }
        visited[row][col] = false;

        return false;
    }
}