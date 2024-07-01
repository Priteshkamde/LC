class Solution {
    public int maxArea(int[] height) {
        int left = 0 ; 
        int right = height.length - 1;
        int area = 0;
        int currArea = 0;
        while(left < right) {
            currArea = Math.abs(left - right) * Math.min(height[left], height[right]);
            area = Math.max(currArea, area);
            
            if(height[left]<height[right]) left++;
            else right--;
        }
        
        return area;
        
    }
}