class Solution {
    public int countSubstrings(String s) {

        if(s == null || s.length() == 0) return 0;

        int N = s.length();

        int start = 0;
        int end = 0;
        int x = 0;

        for(int i = 0 ; i < s.length(); i++){
            x += expand(s, i, i);
            x += expand(s, i, i+1);
        } /// end for loop

        return x;
    }


    private int expand(String s, int left, int right) {
        int count = 0 ;
        while( left >= 0 && right < s.length() && 
            s.charAt(left) == s.charAt(right)) {
                count++;
                left-- ;
                right++ ; 
            }

        return count;
    }
}