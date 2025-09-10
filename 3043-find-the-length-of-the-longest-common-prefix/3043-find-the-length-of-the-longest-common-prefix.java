class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        Set<String> set = new HashSet<>();
        
        for(int a : arr1) {
            String a_string = String.valueOf(a);
            for(int i = 1 ; i <= a_string.length() ; i++)
                set.add(a_string.substring(0, i));
        }

        int maxLen = 0;

        for(int b : arr2) {
            String b_string = String.valueOf(b);
            for(int i = 1 ; i <= b_string.length() ; i++) {
                if(set.contains(b_string.substring(0,i)))
                    maxLen = Math.max(maxLen, i);
            }
        }

        return maxLen;

    }
}