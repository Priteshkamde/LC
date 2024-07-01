class Solution {
    public int maxArea(int[] height) {
        int left = 0 ; 
        int right = height.length - 1;
        int area = 0;
        int currArea = 0;
        // while(left < right) {
        //     area = Math.max((right - left) * Math.min(height[left], height[right]), area);
        //     if(height[left]<height[right]) left++;
        //     else right--;
        // }
        while(left<right){
        if(height[left]<=height[right]){
            area= Math.max(area,height[left]*(right-left));
            left++;
        }
        else{
            area= Math.max(area,height[right]*(right-left));
            right--;
        }
    }
        
        return area;
        
    }
}