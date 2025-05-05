class Solution {
    //  DP
    // O(MxN) and O(MxN)

    // public int[][] updateMatrix(int[][] mat) {
    //     int row = mat.length;
    //     int col = mat[0].length;
    //     int[][] result = new int[row][col];
    //     int INF = row + col;
    //     for(int i = 0 ; i < row ; i++)
    //         for(int j = 0 ; j < col ; j++)
    //             result[i][j] = INF;

    //     for(int i = 0 ; i < row ; i++) {
    //         for(int j = 0 ; j < col ; j++) {
    //             if(mat[i][j] == 0) {
    //                 result[i][j] = 0;
    //             }
    //             else {
    //                 if(i > 0)
    //                     result[i][j] = Math.min(result[i-1][j] + 1, result[i][j]);
    //                 if(j > 0)
    //                     result[i][j] = Math.min(result[i][j-1] + 1, result[i][j]);
    //             }
    //         }
    //     }

    //     for(int i = row-1 ; i >= 0 ; i--) {
    //         for(int j = col-1 ; j >= 0 ; j--) {
    //             if(mat[i][j] != 0) {
    //                 if(i < row - 1) {
    //                     result[i][j] = Math.min(result[i+1][j] + 1, result[i][j]);
    //                 }
    //                 if(j < col - 1) {
    //                     result[i][j] = Math.min(result[i][j+1] + 1, result[i][j]);
    //                 }
    //             }
    //         }
    //     }

    //     return result;
    // }

    // BFS
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[row][col];
        Queue<int[]> q = new LinkedList<>();
        // set 0 as 0 and add to queue
        // set remaining 1s as -1 (unvisited)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    result[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // BFS
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for(int[] direction : dirs) {
                int newRow = r + direction[0];
                int newCol = c + direction[1];
                if(newRow >= 0 && newCol >= 0 && newRow < row && newCol < col && result[newRow][newCol] == -1) {
                    result[newRow][newCol] = result[r][c] + 1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        return result;
    }
}