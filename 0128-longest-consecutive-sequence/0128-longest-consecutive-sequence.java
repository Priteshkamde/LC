
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=0;
        for(int i :set){
            if(!set.contains(i-1)){
                int cnt =1,x=i;
                while(set.contains(x+1)){
                    cnt++;x++;
                }
                max = Math.max(cnt,max);
            }
        }
        return max;
    }
}
