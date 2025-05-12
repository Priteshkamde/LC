class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty())
                    return false;
                
                char popChar = stack.pop();
                    if(c == ')' && popChar != '(')
                        return false;
                    if(c == ']' && popChar != '[')
                        return false;
                    if(c == '}' && popChar != '{')
                        return false;
                
            }
        }
        return stack.isEmpty();
    }
}