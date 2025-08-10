class Solution {
    // O of N^2
    // space is constant
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";

        int max = 0;
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < s.length(); i++) {
            int[] oddLen = expand(s, i, i);
            int[] evenLen = expand(s, i, i+1);

            int maxLen[] = (oddLen[1] - oddLen[0]) > (evenLen[1] - evenLen[0]) ? oddLen : evenLen;

            if(maxLen[1] - maxLen[0] > end-start) {
                start = maxLen[0];
                end =  maxLen[1];
            }
        }

        return s.substring(start, end+1);
    }

    int[] expand(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
        }
        return new int[]{start+1, end-1};
    }
}