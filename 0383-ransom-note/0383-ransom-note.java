class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] magazineChars = new int[26];

        for(char m : magazine.toCharArray()) 
            magazineChars[m - 'a']++;

        for(char r : ransomNote.toCharArray()) {
            magazineChars[r - 'a']--;
            if(magazineChars[r - 'a'] < 0)
                return false;
        }
        

        return true;
    }
}