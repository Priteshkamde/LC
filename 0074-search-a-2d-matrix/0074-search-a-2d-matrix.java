class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;

        int r = 0;
        int c = cols;

        while(r >= 0 && c >= 0 && r <= rows && c <= cols) {
            if(matrix[r][c] == target)
                return true;
            
            if(target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }
}