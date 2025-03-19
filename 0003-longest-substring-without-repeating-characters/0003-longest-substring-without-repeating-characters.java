class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        if(s.length() == 1) return 1;

        HashSet<Character> set = new HashSet();
        int left = 0; 
        int maxLen = 1;

        for(int right = 0 ; right < s.length() ; right++){
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}