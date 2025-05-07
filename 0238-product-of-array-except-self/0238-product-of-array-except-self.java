class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] prefix = new int[N];
        int[] suffix = new int[N];

        prefix[0] = 1;
        System.out.println(Arrays.toString(prefix));
        for(int i = 1 ; i < N ; i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }
        System.out.println(Arrays.toString(prefix));
        suffix[N-1] = 1;
        System.out.println(Arrays.toString(suffix));
        for(int i = N-2 ; i >= 0 ; i--) {
            suffix[i] =  nums[i+1] * suffix[i+1];
        }
        System.out.println(Arrays.toString(suffix));
        int[] result = new int[N];  
        for(int i = 0 ; i < N ; i ++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}