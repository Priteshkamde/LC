class Solution {
    public long[] sumOfThree(long num) {

        for(int i = 0 ; i < num-3; i++) {
            for(int j = i+1 ; j < num-2 ; j++) {
                for(int k = j+1 ; k < num-1 ; k++) {
                    if(i+1 == j && j+1 ==k && i+j+k == num) {
                            return new long[]{i,j,k};
                        }
                    }
                }   
            }

        return new long[0];
    }
}