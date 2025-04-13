class Solution {
    public int[][] generateMatrix(int n) {
        int rowEnd = n-1;
        int colEnd = n-1;
        int rowBegin = 0;
        int colBegin = 0;
        int[][] mat = new int[n][n];
        int ptr = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            
            for(int j = colBegin ; j <= colEnd ; j++) {
                mat[rowBegin][j] = ptr;
                ptr++;
            }
            
            rowBegin++;
            for(int j = rowBegin; j <= rowEnd ; j++) {
                mat[j][colEnd] = ptr;
                ptr++;
            }

            //left
            colEnd--;
            for(int j = colEnd; j >= colBegin ; j--) {
                    mat[rowEnd][j] = ptr;
                    ptr++;
                }

            //up
            rowEnd--;
            for(int j = rowEnd; j >= rowBegin ; j--) {
                    mat[j][colBegin] = ptr;
                    ptr++;
                }

            colBegin++;
        }

        return mat;

    }
}