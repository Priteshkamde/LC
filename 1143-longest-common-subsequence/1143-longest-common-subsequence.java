class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int a = text1.length();
        int b = text2.length();
        int[][] dp = new int[a+1][b+1];
        for(int i = 1 ; i <= a ; i++) {
            for(int j = 1 ; j <= b ; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[a][b];
    }
}