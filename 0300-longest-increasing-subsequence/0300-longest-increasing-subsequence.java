class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for(int x : nums) {

            int i = 0 ; int j = size;
            while(i != j) {
                int mid = (i+j)/2 ;

                if(tails[mid] < x) // incoming number is greater try adding it in the tails since we need increasing seq
                    i = mid + 1;
                else 
                    j = mid;
            }
            // add it to i'th index
            tails[i] = x;
            if ( i == size ) ++size;
        }

        return size;
    }
}