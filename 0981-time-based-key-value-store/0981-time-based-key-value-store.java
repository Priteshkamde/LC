class TimeMap {

    class Data {
        String value;
        int timestamp;
        public Data(String value, int timestamp){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<Data>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Data> list = map.get(key);

        return helper(list, timestamp);
    }

    public String helper(List<Data> list, int timestamp){
        // binary search in the list
        int low = 0;
        int high = list.size()-1;

        while(low < high) {
            int mid = (low + high + 1)/2;
            if(list.get(mid).timestamp <= timestamp) {
                low = mid;
            }  else {
                high = mid - 1;
            }
        }
        return list.get(low).timestamp > timestamp ? "" : list.get(low).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */