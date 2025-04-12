class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        int rowBegin = 0;
        int colBegin = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            
            for(int j = colBegin ; j <= colEnd ; j++) {
                result.add(matrix[rowBegin][j]);
            }
            
            rowBegin++;
            for(int j = rowBegin; j <= rowEnd ; j++) {
                result.add(matrix[j][colEnd]);
            }

            //left
            colEnd--;
            if(rowBegin <= rowEnd)
                for(int j = colEnd; j >= colBegin ; j--) {
                    result.add(matrix[rowEnd][j]);
                }

            //up
            rowEnd--;
            if(colBegin <= colEnd)
                for(int j = rowEnd; j >= rowBegin ; j--) {
                    result.add(matrix[j][colBegin]);
                }

            colBegin++;
        }

        return result;

    }
}