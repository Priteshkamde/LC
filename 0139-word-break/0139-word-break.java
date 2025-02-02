class Solution {

    Map<String, Boolean> cache = new HashMap();

    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(wordDict.contains(s)) return true;

        if(cache.containsKey(s)) return cache.get(s);

        for(int i = 1; i <= s.length() ; i++){
            String left = s.substring(0,i);
            if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                cache.put(s, true);
                return true;
            }
        }


        cache.put(s, false);
        return false;
    }
}