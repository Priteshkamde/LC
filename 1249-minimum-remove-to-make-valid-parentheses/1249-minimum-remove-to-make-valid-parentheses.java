class Solution {
    public String minRemoveToMakeValid(String s) {

        // approach
        // build a stack for opening brackets
        // possible encounters are ( ) char
        // for opening add to stack - cz it needs to be balanced
        // for closing add ony if we have an opening in stack - (check stack empty)
            // remove from stack 
        // if its a normal char - simply add to string builder

        // once this is done - remove any unmtached opening - buy popping them from stack

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(c);
                stack.push(sb.length());
            }

            else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(c);
                }
            }

            else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop() - 1);
        }

        return sb.toString();
    }
}