class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];

        for(char c : magazine.toCharArray()) {
            array[c-'a']++;
        }

        for(char c : ransomNote.toCharArray()) {
            if(--array[c-'a'] < 0)
                return false;
        }

        return true;
    }
}