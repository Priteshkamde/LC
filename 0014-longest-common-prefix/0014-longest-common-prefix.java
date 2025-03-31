class Solution {
    public String longestCommonPrefix(String[] strs) {
        String retString = "";
        int counter = 0;
        if(strs == null || strs.length == 0){return retString;}

        // O(M - no of strings x N - max chars in string)
        for(char c : strs[0].toCharArray()) {
            for(int  i = 1 ; i < strs.length; i++){
                if(counter >= strs[i].length() || c != strs[i].charAt(counter)) {
                    return retString;
                }                
            }
            retString+=c;
            counter++;
        } // for 1
        
        return retString;
    }
}