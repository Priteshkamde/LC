class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE; 
        int[] leftArray = new int[N];
        leftArray[0] = 0;
        int[] rightArray = new int[N];
        rightArray[N-1] = 0;

        for(int i = 0 ; i < N-1 ; i++){
            leftMax = Math.max(leftMax, height[i]);
            leftArray[i] = leftMax - height[i];
        }
        for(int i = N-1 ; i >= 0 ; i--){
            rightMax = Math.max(rightMax, height[i]);
            rightArray[i] = rightMax - height[i];
        }
        int water = 0;
        int i = 0;
        while(i<N){
            water += Math.min(leftArray[i], rightArray[i]);
            i++;
        }
        return water;
    }
}