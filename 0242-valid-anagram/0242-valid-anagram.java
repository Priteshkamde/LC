class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] charArray = new int[26];

        for(char ch : s.toCharArray()) {
            charArray[ch-'a']++; 
        }

        for(char ch : t.toCharArray()) {
            if(--charArray[ch-'a'] < 0)
                return false;
        }

        return true;
    }
}