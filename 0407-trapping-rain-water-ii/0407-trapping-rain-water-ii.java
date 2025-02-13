class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        int totalUnvisitedCells = rows * cols;
        boolean visited[][] = new boolean[rows][cols];  
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (a[0]-b[0])
        );

        for(int i = 0 ; i < rows ; i++){
            pq.offer(new int[]{ heightMap[i][0], i,  0});
            pq.offer(new int[]{ heightMap[i][cols-1], i,  cols-1});
            visited[i][0] = true;
            visited[i][cols-1] = true;
            totalUnvisitedCells--;
            totalUnvisitedCells--;
        }

        for(int i = 1 ; i < cols-1 ; i++){
            pq.offer(new int[]{ heightMap[0][i], 0, i});
            pq.offer(new int[]{ heightMap[rows-1][i], rows-1,  i});
            visited[0][i] = true;
            visited[rows-1][i] = true;
            totalUnvisitedCells--;
            totalUnvisitedCells--;
        }

        int trappedWater = 0;
        int waterLevel = 0;

        while(!pq.isEmpty() && totalUnvisitedCells>0) {
            int currentCell[] = pq.poll();
            int currHeight = currentCell[0];
            int currRow = currentCell[1];
            int currCol = currentCell[2];
            waterLevel = Math.max(waterLevel, currHeight);
            // explore 4 directions
            for(int direction = 0 ; direction < directions.length ; direction++){
                int newRow = currRow + directions[direction][0];
                int newCol = currCol + directions[direction][1];

                // ensure within boundaries and must not be visited
                if(isValidCell(newRow, newCol, rows, cols) && !visited[newRow][newCol]){
                    int newHeight = heightMap[newRow][newCol];
                    // add only if there is a dip
                    if(newHeight < waterLevel) {
                        trappedWater += waterLevel - newHeight;
                    }
                    pq.offer(new int[]{newHeight, newRow, newCol});
                    visited[newRow][newCol] = true;
                    totalUnvisitedCells--;
                }
            }
        }
        return trappedWater;
    }

    private boolean isValidCell(int row, int col, int rows, int cols){
        return row>=0 && col>=0 && row<rows && col<cols;
    }
}