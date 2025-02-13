class Solution {
    public int maxArea(int[] height) {
        int N = height.length;
        int maxA = 0;
        int left = 0;
        int right = N-1;

        while(left<right){
            //area L * B
            // L = min( height[left], height[right] )
            // B = diff of indexes (right - left)
            if(height[left] <= height[right]) {
                maxA = Math.max(maxA, height[left]*(right-left));
                left++;
            } else {
                maxA = Math.max(maxA, height[right]*(right-left));
                right--;
            }
        }

        return maxA;
        
    }
}