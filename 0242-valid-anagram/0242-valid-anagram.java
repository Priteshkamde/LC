class Solution {
    public boolean isAnagram(String s, String t) {
        
        HashMap<Character, Integer> map = new HashMap();
        for(Character a : s.toCharArray()){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for(Character r : t.toCharArray()){
            map.put(r, map.getOrDefault(r, 0) - 1);
        }

        for(int value: map.values())
            if(value != 0)
                return false;

        return true;
    }
}