class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];

        Stack<Integer> stack = new Stack<>();
        
        for(int i = N - 1; i >= 0 ; i--) {
            
            while(!stack.isEmpty() && 
                  temperatures[i] >= temperatures[stack.peek()]) {
         stack.pop();   
        }
        
        if(!stack.isEmpty()) {
            res[i] = stack.peek() - i;
        }
         
        stack.push(i);    
            
        }

        return res;
        
    }
}