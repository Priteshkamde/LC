class RandomizedSet {

    ArrayList<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        
        // add in last
        list.add(val);
        // update map
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int lastElement = list.get(list.size()-1);
        int indexToRemove = map.get(val);
        // bring last element fwd
        list.set(indexToRemove, lastElement);
        // update the map for index update
        map.put(lastElement, indexToRemove);

        list.remove(list.size()-1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */