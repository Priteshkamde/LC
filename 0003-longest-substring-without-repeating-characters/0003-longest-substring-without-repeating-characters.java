class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int max = 0;

        while(right < s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, right-left+1);
                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}