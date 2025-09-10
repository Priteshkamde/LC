class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int total = 0;
        boolean hasOddEl = false;
        for(char c : map.keySet()) {
            int freq = map.get(c);

            if(freq % 2 == 0){
                total += freq;
            } else {
                total += (freq-1);
                hasOddEl = true;
            }
        }

        return (hasOddEl) ? total + 1 : total;

    }
}