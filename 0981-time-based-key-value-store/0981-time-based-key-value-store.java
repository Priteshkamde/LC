class Data {
    String value;
    int timeStamp;
    public Data(String value, int timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }
}

class TimeMap {
    Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Data data = new Data(value, timestamp);
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(data);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";

        List<Data> retrievedList = map.get(key);
        String s = find(retrievedList, timestamp);

        return s;
    }

    public String find(List<Data> list, int inputTimestamp) {
        int low = 0;
        int high = list.size()-1;
        String res = "";
        int mid = 0;
        while(low<=high) {
            mid = low + (high-low)/2;

            if(list.get(mid).timeStamp <= inputTimestamp) {
                res = list.get(mid).value; // value extract here
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */