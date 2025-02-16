class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();

        for (String token : tokens) {
            if (isNumber(token))
                stack.push(Integer.parseInt(token));

            else {
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;
                switch (token) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = b - a;
                        break;
                    case "/":
                        c = b / a;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    default:
                        break;
                }
                stack.push(c);
            }
        }

        return stack.peek();
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}