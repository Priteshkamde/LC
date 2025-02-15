class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] first = new int[26];
        int[] second = new int[26];

        for(char c : s1.toCharArray()){
            first[c-'a']+=1;
        }

        int windowLen = s1.length()-1;
        for(int i = 0 ; i < s2.length() ; i++) {
            second[s2.charAt(i)-'a']+=1;
            if(i >= windowLen){
                if(match(first, second)){
                    return true;
                }
                second[s2.charAt(i-windowLen)-'a']-=1;
            }

        }
        return false;
    }

    private boolean match(int[] first, int[] second) {
        for(int i = 0 ; i < 26 ; i++)
            if(first[i] != second[i])
                return false;
    
        return true;
    }
}