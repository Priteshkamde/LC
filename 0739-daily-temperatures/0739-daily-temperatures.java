class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] result = new int[N];
        int index = 0;

        Stack<Integer> stack = new Stack();

        for(int i = N-1 ; i >= 0 ; i--){
            // pop all lower or equal values
            // than current index value
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }

            // stack has elements, a next warmer day is present
            if(!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}