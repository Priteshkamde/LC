class Solution {
    public long[] sumOfThree(long num) {
        
        if(num%3 != 0)
            return new long[]{};
        
        long a = num/3;
        
        return new long[] {a-1,a,a+1};
    }
}