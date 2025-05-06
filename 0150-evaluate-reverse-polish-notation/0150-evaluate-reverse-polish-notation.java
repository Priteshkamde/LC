class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Set<String> symbols = Set.of("+", "-", "*", "/");
        for (String s : tokens) {
            if (!symbols.contains(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int a = stack.pop();
                int b = stack.pop();

                switch(s)
                {
                    case "*":
                    stack.push(a * b); break;

                    case "-":
                    stack.push(b - a); break;

                    case "+":
                    stack.push(a + b); break;

                    case "/":
                    stack.push(b / a); break;
                }
            }
        }

        return stack.peek();
    }
}