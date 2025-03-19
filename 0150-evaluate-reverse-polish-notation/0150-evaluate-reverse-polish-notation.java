class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();

        for (String token : tokens) {
            if (isNumber(token))
                stack.push(Integer.parseInt(token));

            else {
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }
        }

        return stack.pop();
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