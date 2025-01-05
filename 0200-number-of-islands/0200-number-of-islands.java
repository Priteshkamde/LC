class Solution {
    public int numIslands(char[][] grid) {
        
        int total = 0;
        int rows = grid.length; 
        int cols = grid[0].length; 

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == '1'){
                    total += 1;
                    callBFS(r,c,grid,rows, cols);
                }
            }
        }   
        return total;
    }
    public void callBFS(int r, int c, char[][] grid, int rows, int cols){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        grid[r][c] = 0 ;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0], col = point[1];

            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                && grid[newRow][newCol] == '1') {
                    q.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
}