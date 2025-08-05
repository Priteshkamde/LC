class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char current = s.charAt(right);
            if (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(current);
                maxLen = Math.max(maxLen, set.size());
                right++;
            }
        }

        return maxLen;
    }
}