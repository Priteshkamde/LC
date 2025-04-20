class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        
        while(last.indexOf(first) != 0) {
                first = first.substring(0, first.length()-1);
            }
        

        return first;
    }
}