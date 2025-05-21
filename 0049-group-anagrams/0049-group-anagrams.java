class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            String inputString = s;
            char[] strChar = s.toCharArray();
            Arrays.sort(strChar);
            String tempKeyString = new String(strChar);

            if(map.containsKey(tempKeyString)) {
                map.get(tempKeyString).add(inputString);
            } else {
                map.put(tempKeyString,new ArrayList());
                map.get(tempKeyString).add(inputString);
            }
        }

        return new ArrayList<>(map.values());
    }
}