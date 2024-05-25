class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hms = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmt = new HashMap<Character, Integer>();
        
        for(char c : s.toCharArray()){
            if(hms.containsKey(c)) hms.put(c, hms.get(c)+1);
            else hms.put(c, 1);
        }
        
        for(char c : t.toCharArray()){
            if(hmt.containsKey(c)) hmt.put(c, hmt.get(c)+1);
            else hmt.put(c, 1);
        }
        
        return hms.equals(hmt);
    }
}