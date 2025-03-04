class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if(s1Len + s2Len != s3Len)
            return false;

        boolean dp[][] = new boolean[s1Len+1][s2Len+1];
        dp[0][0] = true;

        // first row
        for(int i = 1 ; i <= s1Len ; i++) { 
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        // first col
        for(int j = 1 ; j <= s2Len ; j++) { 
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for(int i = 1 ; i <= s1Len ; i++) {
            for(int j = 1 ; j <= s2Len ; j++) {
                dp[i][j] = 
                ( s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j] ) ||
                ( s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1] );
            }
        }

        return dp[s1Len][s2Len];
        
    }
}