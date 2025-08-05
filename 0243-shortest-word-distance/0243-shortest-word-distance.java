class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        Map<String, Integer> map = new HashMap<>();
        int dist = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length ; i++) {
            if(wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) 
                map.put(wordsDict[i], i);

            if(map.containsKey(word1) && map.containsKey(word2))
                dist = Math.min(dist, Math.abs(map.get(word1) - map.get(word2)));
        }

        return dist;
    }
}