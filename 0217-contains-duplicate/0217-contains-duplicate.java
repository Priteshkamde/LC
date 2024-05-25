class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet hs = new HashSet();
        
        for(int x : nums){
            if(hs.contains(x)) return true;
            else hs.add(x);
        }
        
        return false;
    }
}