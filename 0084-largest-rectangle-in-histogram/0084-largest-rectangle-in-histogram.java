class Solution {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack();

        for(int i = 0 ; i < N ; i++) {
            // stack has a bigger element than the array element
            // or say incoming array element is smaller than the current stack top
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int element = stack.pop();
                // retreive the NSE (next small element)
                int nse = i;
                // pop the stack top to get previous small element
                // if not then its -1
                int pse = stack.isEmpty() ? -1 : stack.peek();
                // caculate area
                maxArea = Math.max(maxArea, heights[element] * (nse-pse-1));
            }
            stack.push(i);
        }

        // still stack will have small elements
        // for the NSE we need to assume the length of array
        // for PSE pop from stack
        while(!stack.isEmpty()){
            int nse = N;
            int element = stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse-pse-1));
        }

        return maxArea;
    }
}