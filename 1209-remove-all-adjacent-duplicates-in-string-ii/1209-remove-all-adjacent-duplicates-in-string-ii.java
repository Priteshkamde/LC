class Pair {
    char c;
    int freq;   
    Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
    int getFreq(char c) {
        return freq;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for(Character ch : s.toCharArray()) {
            
            // if equals -> finding adjacents
            if(!stack.isEmpty() && stack.peek().c == ch) {
                stack.peek().freq++;
        
                if(stack.peek().freq == k) {
                    stack.pop();
                }
            }
            // else -> not adjacenty 
            else {
                stack.push(new Pair(ch, 1));
            }   
        }

        // stack either empty || Pair <a,4>
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            while(p.freq-- > 0) {
                sb.append(p.c);
            }
        }

        return sb.reverse().toString();
    }
}