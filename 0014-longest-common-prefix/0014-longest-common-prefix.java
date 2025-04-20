class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];

        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder();

        String first = strs[0];
        String last = strs[strs.length-1];

        System.out.println(Arrays.toString(strs));

        for(int i = 0 ; i < first.length() ; i ++) {
            if(first.charAt(i) == last.charAt(i)) {
                sb.append(first.charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }
}