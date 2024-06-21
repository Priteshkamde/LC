class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        if (s.length() == 0)
            return true;
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start <= end) {
            char a = s.charAt(start);
            char z = s.charAt(end);
            
            if (!Character.isLetterOrDigit(a)) {
                start++;
            } else if (!Character.isLetterOrDigit(z)) {
                end--;
            } else {
                if (Character.toLowerCase(a) != Character.toLowerCase(z)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        
        return true;
    }
}
