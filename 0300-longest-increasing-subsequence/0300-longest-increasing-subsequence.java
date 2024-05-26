class Solution {
    public int lengthOfLIS(int[] nums) {
        
    // using DP to keep a track
    // we cannot have a increasing subseq 
    // if the element X has a lower value then x+1..n
    // DP array will keep a track starting from the end index
    // reverse loop
    
        int N = nums.length;
        int LIS[] = new int[N];
        Arrays.fill(LIS, 1); //default is 1 since the number itself is a minimum seq
          
        LIS[N-1] = 1;
        for (int i = N-1 ; i >= 0 ; i--)
            for(int curr = i+1; curr < N ; curr++)
                if(nums[i]<nums[curr])
                    LIS[i] = Math.max(LIS[i],1+LIS[curr]);
        
        System.out.println(Arrays.toString(LIS));
        return Arrays.stream(LIS).max().getAsInt();
        
    }
}