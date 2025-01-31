class Solution {
    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0) return "";

        int N = s.length();

        int start = 0;
        int end = 0;

        for(int i = 0 ; i < s.length(); i++){
            int oddLen = expand(s, i, i);
            int evenLen = expand(s, i, i+1);

            int len = Math.max(oddLen, evenLen);
            if(len > end-start) {
                start = i - (len-1)/2; // start index is half way behind center 
                end = i + (len/2); // end index is halfway ahead of center
            }

        } /// end for loop

        return s.substring(start, end+1);
    }


    private int expand(String s, int left, int right) {
        while( left >= 0 && right < s.length() && 
            s.charAt(left) == s.charAt(right)) {
                left-- ;
                right++ ; 
            }

        return right-left-1;
    }
}