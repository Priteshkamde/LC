class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] ch = new int[26];

        for(char c : s.toCharArray()) ch[c-'a']++;
        for(char c : t.toCharArray()) ch[c-'a']--;
        for(int x : ch) 
            if(x != 0) 
                return false;
        return true;
    }
}