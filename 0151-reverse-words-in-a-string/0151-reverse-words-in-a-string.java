class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int start = 0;
        while(end >= 0) {
            
            while (end >= 0 && s.charAt(end) == ' ') 
                end--;

            start = end;
            
            while (start >= 0 && s.charAt(start) != ' ') 
                start--;
            
            sb.append(s.substring(start + 1, end + 1));
            sb.append(" ");
            
            end = start;
        }

        return sb.toString().trim();
    }
}