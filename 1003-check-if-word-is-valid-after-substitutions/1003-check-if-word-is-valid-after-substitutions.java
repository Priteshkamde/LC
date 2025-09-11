class Solution {
    public boolean isValid(String s) {
        
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            sb.append(c);

            if( sb.length() >=3 && sb.substring(sb.length()-3).equals("abc") )
            {
                sb.delete(sb.length()-3, sb.length());
            }
        }

        return sb.length() == 0;
    }
}