class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;

        if(needle.length() > haystack.length())
            return result;
        
        for(int i = 0 ; i <= haystack.length() - needle.length(); i++) {
            if(needle.equals(haystack.substring(i, i+needle.length())))
                return i;
        }

        return result;
    }
}