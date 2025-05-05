class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[row][col];

        for(int i = 0 ; i < row ; i++)
            for(int j = 0 ; j < col ; j++)
                result[i][j] = Integer.MAX_VALUE;

        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col ; j++) {
                if(mat[i][j] == 0) {
                    result[i][j] = 0;
                }
                else {
                    if(i > 0)
                        result[i][j] = Math.min(result[i-1][j] + 1, result[i][j]);
                    if(j > 0)
                        result[i][j] = Math.min(result[i][j-1] + 1, result[i][j]);
                }
            }
        }

        for(int i = row-1 ; i >= 0 ; i--) {
            for(int j = col-1 ; j >= 0 ; j--) {
                if(mat[i][j] != 0) {
                    if(i < row - 1) {
                        result[i][j] = Math.min(result[i+1][j] + 1, result[i][j]);
                    }
                    if(j < col - 1) {
                        result[i][j] = Math.min(result[i][j+1] + 1, result[i][j]);
                    }
                }
            }
        }
        
    return result;
    }
}