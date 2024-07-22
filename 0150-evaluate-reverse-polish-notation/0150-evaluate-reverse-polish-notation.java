
class Solution {
    
    long resolveIt(long a, long b, char op) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
    
    public int evalRPN(String[] tokens) {
        
        Stack<Long> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                long a = stack.pop();
                long b = stack.pop();
                long res = resolveIt(b, a, token.charAt(0)); // b op a
                stack.push(res);
            } else {
                stack.push(Long.parseLong(token));
            }
        }
        
        return stack.pop().intValue();
    }
}
