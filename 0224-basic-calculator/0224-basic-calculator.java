public class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;  // +1 for positive, -1 for negative

        Stack<Integer> stack = new Stack<>();
    
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0'); // build number
            }

            else if (ch == '+') {
                // add previous number with current sign
                result += sign * number;
                number = 0; 
                sign = 1;
            }

             else if (ch == '-') {
                // add previous number with current sign
                result += sign * number;
                number = 0; 
                sign = -1;
            }

            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }

            else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if(number != 0)
            result += sign * number;

        return result;
    }
}
