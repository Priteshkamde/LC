class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int i=0;
        while(i < s.length()) {
            if(!s1.isEmpty() && s.charAt(i) == '#') {
                s1.pop();
            }
            else if (s.charAt(i) != '#'){
                s1.push(s.charAt(i));
            }
            i++;
        }
        i = 0;
        while(i < t.length()) {
            if(!s2.isEmpty() && t.charAt(i) == '#') {
                s2.pop();
            }
            else if (t.charAt(i) != '#'){
                s2.push(t.charAt(i));
            }
            i++;
        }

        System.out.println(s1);
        System.out.println(s2);

        while(!s1.isEmpty() && !s2.isEmpty()) {
            if(s1.pop() != s2.pop())
                return false;
        }

        if(s1.size() != s2.size())
            return false;

        return true;

    }
}