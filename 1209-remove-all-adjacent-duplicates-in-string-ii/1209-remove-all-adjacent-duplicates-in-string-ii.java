class Pair {
    char c;
    int freq;   
    Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        for(Character ch : s.toCharArray()) {
            
            // if equals -> finding adjacents
            if(!stack.isEmpty() && stack.peekLast().c == ch) {
                stack.peekLast().freq++;
        
                if(stack.peekLast().freq == k) {
                    stack.removeLast();
                }
            }
            // else -> not adjacenty 
            else {
                stack.addLast(new Pair(ch, 1));
            }
        }

        // stack either empty || Pair <a,4>
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            sb.append(String.valueOf(p.c).repeat(p.freq));
        }

        return sb.toString();
    }
}