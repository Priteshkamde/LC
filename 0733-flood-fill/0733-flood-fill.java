class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int currColor = image[sr][sc];
        if (currColor == color) return image; 

        int maxRow = image.length;
        int maxCol = image[0].length;

        paint(sr,sc,color,maxRow,maxCol,image, currColor);

        return image;
    }

    public void paint(int row,int col,int color,int maxRow, int maxCol, int[][] image, int currColor){

        if(row < 0 || col < 0 || row >= maxRow || col >= maxCol)
            return;
        if (image[row][col] != currColor) 
            return;
        
        image[row][col] = color;

        paint(row+1, col, color, maxRow, maxCol, image, currColor);
        paint(row, col+1, color, maxRow, maxCol, image, currColor);
        paint(row-1, col, color, maxRow, maxCol, image, currColor);
        paint(row, col-1, color, maxRow, maxCol, image, currColor);
    }
}