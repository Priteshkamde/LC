class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        int rowBegin = 0;
        int colBegin = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // towards right
            for (int j = colBegin; j <= colEnd; j++)
                result.add(matrix[rowBegin][j]);

            // down
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++)
                result.add(matrix[i][colEnd]);

            // towards left
            colEnd--;
            if (rowBegin <= rowEnd)
                for (int x = colEnd; x >= colBegin; x--)
                    result.add(matrix[rowEnd][x]);
            // up
            rowEnd--;
            if (colBegin <= colEnd)
                for (int x = rowEnd; x >= rowBegin; x--)
                    result.add(matrix[x][colBegin]);

            colBegin++;
        }
        return result;
    }
}