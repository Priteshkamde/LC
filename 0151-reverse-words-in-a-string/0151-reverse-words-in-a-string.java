class Solution {
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>(); 
        for(char c : s.toCharArray()) {
            if(c == ' '){
                if(sb.length()>0) {
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
            }
            else {
                sb.append(c);                
            }
        }

        if (sb.length() > 0) {
            stack.push(sb.toString());
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            if (!stack.isEmpty()) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}