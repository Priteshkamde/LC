class Solution {
    // O of N
    // space constant

    // -> example
    /**
    init status with all as -1
    and put their index in array
    abc -> status = [0,1,2]
    find the minimum index in status array and do +1
    for abc its [0,1,2] -> 0+1 = solution as 1
    for aabc its [1,2,3] -> 1+1 = solution as 2
     */
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