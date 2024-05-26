
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums) {
            hs.add(x);
        }
        
        int max = 0;
        
        for (int x : nums) {
            
            if (!hs.contains(x - 1)) {
                int currentNum = x;
                int currMax = 1;

                while (hs.contains(currentNum + 1)) {
                    currentNum++;
                    currMax++;
                }                
                max = Math.max(max, currMax);
            }
        }
        
        return max;
    }
}
