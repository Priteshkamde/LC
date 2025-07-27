class Solution {
    public boolean isValid(String s) {
        
        if (s.length() %2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else {
                if(stack.isEmpty())
                    return false;
            
                char popChar = stack.pop();
                if(popChar == '{' && c != '}')
                    return false;
                if(popChar == '(' && c != ')')
                    return false;
                if(popChar == '[' && c != ']')
                    return false;
            }
        }

        return stack.isEmpty();

    }
}