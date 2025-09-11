class Solution {
    public String smallestSubsequence(String s) {
        
        StringBuilder sb = new StringBuilder();

        int[] freq = new int[26];
        for(char ch : s.toCharArray()) 
            freq[ch - 'a']++;

        boolean[] inStackRightNow = new boolean[26];

        for(char ch : s.toCharArray()) {
            // reduce freq
            freq[ch - 'a']--;
            
            // skip if already accounted for
            if(inStackRightNow[ch - 'a'])
                continue;


            // monotonic stack apporach
            while(sb.length() > 0  && // boudary check
                ch < sb.charAt(sb.length()-1) &&  // c > a -> so pop from stack
                freq[sb.charAt(sb.length()-1) - 'a'] > 0 ) { // ensure that the freq is present for future usage
                    inStackRightNow[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length()-1); // remove from stack
                }

            sb.append(ch);
            inStackRightNow[ch-'a']=true;
        }

        return sb.toString();
    }
}