class Solution {
    public int findDuplicate(int[] nums) {
       
        int N = nums.length;
        boolean[] status = new boolean[N-1];

        for(int i = 0 ; i < N ; i++) {
            if(status[nums[i]-1]) 
                return nums[i];
            else 
                status[nums[i]-1] = true;
        }

        return -1;
    }
}