class Solution {
    public int lengthOfLastWord(String s) {
        
        s = s.trim();

        String[] words = s.split(" ");

        String lastWord = words[words.length-1];

        return lastWord.length();
    }
}