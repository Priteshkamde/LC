class Solution {
    public int[] findErrorNums(int[] nums) {
        
        boolean[] status = new boolean[nums.length];
        int dupli = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(status[nums[i]-1]) {
                dupli = nums[i];
            } else {
                status[nums[i]-1] = true;
            }
        }

        int missing = 0;
        for(int i = 0 ; i < status.length; i++) {
            if(!status[i])
                missing = i;
        }

        return new int[]{dupli, missing+1};
    }
}