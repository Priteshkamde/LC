class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums1)
            map.put(n, map.getOrDefault(n, 0)+1);

        for(int n : nums2) {
            if(map.containsKey(n) && map.get(n) > 0 ){
                res.add(n);
                map.put(n, map.get(n)-1);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        
        return ans;

    }
}