class Solution {
    // O of N
    // space constant
    public int numberOfSubstrings(String s) {
        
        int[] status = new int[]{-1,-1,-1};
        int sum = 0;

        for(int i = 0 ; i < s.length() ; i++) {
            status[s.charAt(i)-'a'] = i;

            if(status[0] != -1 && status[1] != -1 && status[2] != -1) {
                sum += Math.min(status[0], Math.min(status[1], status[2])) + 1;
            }
        }   

        return sum;
    }
}