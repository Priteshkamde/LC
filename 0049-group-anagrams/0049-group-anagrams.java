class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            // Convert the string to a character array
            char[] charArray = strs[i].toCharArray();

            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (!map.containsKey(sortedString)) {
            map.put(sortedString, new ArrayList<>());
            }

        
        map.get(sortedString).add(strs[i]);
        }
            
        List<List<String>> listOfLists = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            listOfLists.add(entry.getValue());
        }

        return listOfLists;
    }
}
