class Solution {
    public int findDuplicate(int[] nums) {
        
        int N = nums.length;
        boolean[] status = new boolean[N];

        for(int i = 0 ; i < N ; i++) {
            // if found return int
            if(status[nums[i]-1])
                return nums[i];
            // else put in arr and mark as true
            else {
                status[nums[i]-1] = true;
            }
        }

        return -1;
    }
}