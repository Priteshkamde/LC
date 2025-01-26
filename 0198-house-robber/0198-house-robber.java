class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int N = nums.length;
        int totalCost[] = new int[N];

        totalCost[0] = nums[0];
        totalCost[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2 ; i < N ; i++) {
            totalCost[i] = Math.max(
                    nums[i] + totalCost[i-2],
                    totalCost[i-1]
                );
        }

        return totalCost[N-1];
    }
}