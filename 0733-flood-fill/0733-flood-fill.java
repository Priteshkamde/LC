class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        
    if ( image[sr][sc] ==  color) return image;    
    fill(image, sr, sc, image[sr][sc] ,color);
            return image;
    }
    
    public void fill(int[][] img, int row, int col,  int color, int newColor) {
        
        if( row < 0 || row >= img.length || 
           col < 0 || col >= img[1].length || img[row][col]!=color) return;
        
        img[row][col] = newColor;
        fill(img,row-1,col,color, newColor);
        fill(img,row+1,col,color, newColor);
        fill(img,row,col+1,color, newColor);
        fill(img,row,col-1,color, newColor);

    }
}