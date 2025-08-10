class Solution {
    public boolean isMatch(String s, String p) {
        int A = s.length();
        int B = p.length();
        
        boolean[][] T = new boolean[A+1][B+1];
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();

        T[0][0] = true;
        for(int i = 1; i < T[0].length; i++) {
            if(pattern[i-1] == '*') {
                T[0][i] = T[0][i-2];
            }
        }


        for(int i = 1 ; i < T.length ; i++) {
            for(int j = 1 ; j < T[0].length ; j++) {

                if(pattern[j-1] == '.' || pattern[j-1] == text[i-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if(pattern[j-1] == '*') {
                    T[i][j] = T[i][j-2]; // check 2 steps back

                    if(pattern[j-2] == '.' || pattern[j-2] == text[i-1]) {
                        T[i][j] = T[i][j] | T[i-1][j];
                    }
                }
                else {
                    T[i][j] = false;
                }
            } 
        }

        return T[A][B];
    }
}