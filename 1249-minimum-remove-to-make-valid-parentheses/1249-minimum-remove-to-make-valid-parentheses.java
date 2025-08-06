class Solution {
    public String minRemoveToMakeValid(String s) {

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