class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minK = Integer.MAX_VALUE;
        int N = piles.length;
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        // binary search to compare h and currentH

        while(low <= high){
            int mid = low + (high-low)/2;
            long currentK = helper(piles, mid);
            if(currentK <= h){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;

        // helper function to get the bananas eaten
    }

    public long helper(int[] piles, int x) {
        long totalHours = 0;
        for (int bananas : piles) {
            totalHours += (int) Math.ceil((double) bananas / x);
        }
        return totalHours;
    }
}