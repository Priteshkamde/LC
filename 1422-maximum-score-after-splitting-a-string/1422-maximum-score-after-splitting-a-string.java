class Solution {
    // (O of N^2 solution)
    public int maxScore(String s) {
        int maxScore = 0;
        int N = s.length();
        for(int i = 1; i < s.length(); i++) {
            maxScore = Math.max(
                maxScore,
                countNum(s, 0, i, '0')
                +
                countNum(s, i, N, '1')
            );
        }
        return maxScore;
    }

    int countNum(String s, int start, int end, char c) {
        int count = 0;
        while(start < end) {
            if(s.charAt(start) == c){
                count++;
            }
            start++;
        }
        return count;
    }
}