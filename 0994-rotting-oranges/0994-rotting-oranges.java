class Solution {

    class Pair{
        int r;
        int c;
        int t;
        Pair(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
       
        int rows = grid.length; 
        int cols = grid[0].length; 
        Queue<Pair> q = new LinkedList<>();

        int vis[][] = new int[rows][cols];
        int countFresh = 0;

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) countFresh+=1;
            }
        }
          
    
    
        int maxTime = 0;
        int x = 0 ;
        int count = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int row = q.peek().r, col = q.peek().c, time = q.peek().t;
            maxTime = Math.max(maxTime, time);
            q.remove();
            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    q.add(new Pair(newRow, newCol, time+1));
                    vis[newRow][newCol] = 2;
                    count += 1;
                }
            }
        }

        return (count != countFresh) ?  -1 : maxTime ;
    }
}