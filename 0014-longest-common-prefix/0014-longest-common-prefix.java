class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int count = Integer.MAX_VALUE;
        int currCount = 0;
        for(int i = 0; i < strs.length - 1 ; i++) {
            char[] s1 = strs[i].toCharArray();
            char[] s2 = strs[i+1].toCharArray();
            int p1 = 0;
            currCount = 0;
            while(p1<s1.length && p1<s2.length) {
                if(s1[p1] == s2[p1]) {
                    currCount++;
                    p1++;
                } else {
                    break;
                }
            }
            count = Math.min(count, currCount);
        }

        return count == 0 ? "" : strs[0].substring(0, count);
    }
}