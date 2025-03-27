class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0)+1);

        // handle 1
        int maxLen = 1;
        maxLen = map.containsKey(1) ? map.get(1)%2 == 0 ? map.get(1)-1 : map.get(1) : 1;

        // traverse each number in input array
        for(int i = 0 ; i < nums.length ; i++) {
            int count = 0;
            int num = nums[i];
            while(map.containsKey(num) && map.get(num) >= 2 && num != 1){
                count += 2;
                num = num * num;
            }
            if(map.containsKey(num)){
                count += 1;
            } else {
                count--;
            }
            maxLen = Math.max(count, maxLen);
        }

        return maxLen;
    }
}