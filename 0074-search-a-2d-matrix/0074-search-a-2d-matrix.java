class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        int m = 0;
        int n = maxCol-1;

        while( m >= 0 && m < maxRow && n >= 0 && n < maxCol) {
            if(target == matrix[m][n]){
                return true;
            }
            if(target < matrix[m][n]) {
                n-=1;
            } else {
                m+=1;
            }
        }

        return false;
    }
}