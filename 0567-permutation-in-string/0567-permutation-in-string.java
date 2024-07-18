class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1_array = new int[26];
        int[] s2_array = new int[26];
         int window_size = s1.length();
        
        for(int i = 0 ; i < window_size ; i++) {
            s1_array[s1.charAt(i) - 'a']++;
            s2_array[s2.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(s1_array, s2_array)) return true;
        
        for(int i = window_size ; i < s2.length() ; i++) {
            
            s2_array[s2.charAt(i) - 'a']++;
            s2_array[s2.charAt(i - window_size) - 'a']--;
            
            if(Arrays.equals(s1_array, s2_array)) return true;
        }
        
        return false;
        
    }
}