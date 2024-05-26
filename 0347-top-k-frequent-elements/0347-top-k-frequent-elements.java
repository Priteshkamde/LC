class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        List<Integer>[] list = new List[nums.length+1];
        
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        for(int key: map.keySet()){
            int frequency = map.get(key);
            
            if(list[frequency]==null){
                list[frequency]= new ArrayList<>();
            }
            list[frequency].add(key);
        }
        
        int res[] = new int[k];
        int counter = 0;
        
        for(int pos = list.length-1; pos >=0 && counter < k; pos --){
            
            if(list[pos]!= null){
                for(Integer i : list[pos]){
                    res[counter++] = i;
                }
            }
        }
            
            
        
        return res;
    }
}