class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int resultSum = 0;        

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int key : map.keySet()) {
            if(map.get(key) == 1) {
                resultSum += key;
            }
        }

        return resultSum;
    }
}