class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] charArray = new int[26];

        for(char c : s.toCharArray()) {
            charArray[c - 'a']++;
        }


        for(char c : t.toCharArray()) {
            if(--charArray[c-'a'] < 0) {
                return false;
            }
        }

        return true;
        
    }
}