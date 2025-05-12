class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null)
            return 0;
        
        if(s.length() == 0)
            return 0;
        
        int left = 0;
        int right = 0;



        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        while(right < s.length()) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}