class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int len = 0;
        boolean hasodd = false;
        for(char c : map.keySet()) {
            int count = map.get(c);
            if(count % 2 == 0) {
                len = len + count;
            } else {
                len = len + count - 1; // extract even of the odd
                hasodd = true; // mark this, so that we can add a single odd in the end
            }
        }

        return (hasodd) ? len + 1 : len;
    }
}