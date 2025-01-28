class Solution {
    public String longestPalindrome(String s) {
        
        int N = s.length();
        boolean[][] dp = new boolean[N][N];

        int maxLen = 1;
        int start = 0;

        for(int i = 0 ; i < N ; i++)
            dp[i][i] = true; // diagonals are true

        for(int i = 0 ; i < N-1 ; i++) { // for substring with len=2
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for (int k = 3; k <= N; ++k) {
            for (int i = 0; i < N - k + 1; ++i) {
                
                int j = i + k - 1;
                // a (bbaa) a = check if true within boundary
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    // track k when its maximum
                    // track len as k to extract the string
                    if (k > maxLen) {
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);


        
    }
}