class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 0;

        for (int num : set) { // iterate over set to avoid duplicates
            if (!set.contains(num - 1)) { // start of a sequence
                int currNum = num;
                int currLen = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    currLen++;
                }

                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}
