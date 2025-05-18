class Solution {
    public int removeDuplicates(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];

        if(nums.length == 1) {
            return 1;
        }

        int index = 1;

        for(int i = 1; i < N ; i++) {
            if(nums[i-1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}