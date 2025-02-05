class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> nums1set = new HashSet<>();

        for(int x : nums1)
            nums1set.add(x);
       
        int[] res = new int[nums1set.size()];
        int cursor = 0;
        
        for(int x : nums2) {
            if(nums1set.remove(x)) {
                res[cursor++] = x;
            }
        }

        return Arrays.copyOfRange(res, 0, cursor);
        
    }
}