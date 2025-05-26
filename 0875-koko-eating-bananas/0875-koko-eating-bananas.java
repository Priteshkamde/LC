class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;    
        int right = getMax(piles);

        while(left < right) {
            int mid = left + (right-left)/2;
            
            if(calcSum(piles, mid) > h) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // get max
    private static int getMax(int[] piles) {
        int max = piles[0];
        for(int x : piles) {
            max = Math.max(x, max);
        }
        return max;
    }

    private static int calcSum(int[] piles, int divisor) {
        int sum = 0;
        for(int p : piles) {
            sum += (p+divisor-1)/divisor;
        }
        return sum;
    }

}