class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet set = new HashSet(9);
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                char currentValue = board[i][j]; 
                if(currentValue != '.'){
                    if( 
                    !set.add(currentValue +" found in row" + i) ||
                    !set.add(currentValue +" found in col" + j) ||
                    !set.add(currentValue +" found in box" + i/3 + " "+ j/3)) 
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}