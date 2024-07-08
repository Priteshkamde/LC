class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0) return 0;
        if(s.isEmpty()) return 1;
        
        HashSet hs = new HashSet();
        
        int a_pointer = 0;
        int b_pointer = 0;
       
        int max = 0;
        while( b_pointer < s.length() ) {
            if(!hs.contains(s.charAt(b_pointer))) {
                hs.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(max, hs.size());
            }
            else {
                hs.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        
        return max;
    }
}