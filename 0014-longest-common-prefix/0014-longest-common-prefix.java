class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];

        int index = first.length();

        while(last.indexOf(first) != 0) {
            if(first.isEmpty())
                return "";
            first = first.substring(0, index--);
        }

        return first;
    }
}