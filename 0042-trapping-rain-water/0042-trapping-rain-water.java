class Solution {
    public int trap(int[] height) {
        
        int N = height.length;
        // pointers
        int left = 0;
        int right = N-1;

        // init
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while(left < right) {
            if(height[left] < height[right]) { // LHS
                if(height[left] > leftMax)
                    leftMax = height[left];
    
                water = water + leftMax - height[left];
                left++;
            } else { // RHS
                if(height[right] > rightMax)
                    rightMax = height[right];
                
                water = water + rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}