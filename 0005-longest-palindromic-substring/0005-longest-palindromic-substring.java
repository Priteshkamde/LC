class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";

        int max = 0;
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < s.length(); i++) {
            int oddLen = expand(s, i, i);
            int evenLen = expand(s, i, i+1);

            int len = Math.max(oddLen, evenLen);
            if(len > end-start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }

    int expand(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
        }
        return end-start-1;
    }
}