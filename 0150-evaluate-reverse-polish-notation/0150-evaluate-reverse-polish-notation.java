class Solution {
    
    long resolveIt(long a, long b, char op) {
        if(op == '+') return a+b;
        if(op == '-') return b-a;
        if(op == '*') return a*b;
        return b/a;
    }
    
    public int evalRPN(String[] tokens) {
        
        Stack<Long> stack = new Stack<Long>();
        
        int N = tokens.length;
        for(int i = 0 ; i < N ; i ++) {
            
            if(tokens[i].length() == 1 && tokens[i].charAt(0) < 48) // evaluate 
            {
                long a = stack.pop();
                long b = stack.pop();
                long res = resolveIt(a, b, tokens[i].charAt(0));
                stack.push(res);
            }
            else {
                stack.push(Long.parseLong(tokens[i]));
            }
            
        }
        
        
        return stack.pop().intValue();
        
        
    }
}