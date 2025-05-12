class Solution {
    public void sortColors(int[] nums) {
        int wc = 0;
        int rc = 0;
        int bc = 0;

        for(int col : nums) {
            if(col == 0)    
                rc++;
            if(col == 1)
                wc++;
            if(col == 2) 
                bc++;
        }

        int index = 0;
        while(rc-- > 0)
            nums[index++] = 0;
        while(wc-- > 0)
            nums[index++] = 1;
        while(bc-- > 0)
            nums[index++] = 2;
    }
}