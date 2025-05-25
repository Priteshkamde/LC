class Solution {
    public String removeDuplicates(String s, int k) {

        ArrayDeque<Pair> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == ch) {
                stack.peek().count++;

                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(ch, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.removeLast();
            int count = p.count;
            while (count > 0) {
                sb.append(p.c);
                count--;
            }
        }

        return sb.toString();
    }
}

class Pair {
    char c;
    int count;

    Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}