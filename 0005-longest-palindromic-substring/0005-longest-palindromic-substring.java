class Solution {
    public String longestPalindrome(String s) {

        int N = s.length();
        if(N < 2) return s;

        int longest = 1;
        String maxStr = s.substring(0,1);

        for(int i = 0 ; i < N; i++) {
            for(int j = i + longest ; j <= N ; j++) {
                if(
                        j-i > longest && 
                        isPalindrome(s.substring(i, j)) 
                    ) {
                    longest = j-i;
                    maxStr = s.substring(i,j);
                }
            }
        }

        return maxStr;
    }

    private boolean isPalindrome(String s) {
        
        int N = s.length();
        int left = 0;
        int right = N-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++; 
            right--;
        }
        return true;
    }
}