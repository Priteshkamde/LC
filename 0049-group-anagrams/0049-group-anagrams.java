class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap();
        
        for(String x : strs) {
            char[] givenWord = x.toCharArray();
            Arrays.sort(givenWord);
            String sortedWord = new String(givenWord);
            resultMap.computeIfAbsent(sortedWord, t -> new ArrayList()).add(x);
        }

        return new ArrayList<>(resultMap.values());
    }
}