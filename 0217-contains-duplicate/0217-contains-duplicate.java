class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(int x : nums){
            if(hs.contains(x)) return true;
            else hs.add(x);
        }
        
        return false;
    }
}