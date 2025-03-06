class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        List<Integer> rlist = new ArrayList();
        List<Integer> clist = new ArrayList();
        for(int i = 0 ; i <= rows ; i++ ) {
            for(int j = 0; j <= cols ; j++) {
                if(matrix[i][j] == 0) {
                    rlist.add(i);
                    clist.add(j);
                }
            }
        }
        for(int i = 0 ; i <= rows ; i++ ) {
            for(int j = 0; j <= cols ; j++) {
                if(rlist.contains(i) || clist.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}