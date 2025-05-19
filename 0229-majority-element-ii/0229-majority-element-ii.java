class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int bound = nums.length/3;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for(int key : map.keySet()) {
            if(map.get(key) > bound)
                list.add(key);
        }

        return list;
    }

}