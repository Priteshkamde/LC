class Node {
    int val;
    int freq;
    Node next;
    Node prev;

    Node(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

class LFUCache {
    Map<Integer, Node> map;
    Map<Integer, Set<Integer>> freqMap;
    int cap;
    int minFreq;

    public LFUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(cap);    
        freqMap = new HashMap<>(cap);    
        this.minFreq = 0;
        freqMap.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(map.get(key) == null)
            return -1;
        
        Node node = map.get(key);
        int currFreq = node.freq;
        node.freq++;
        map.put(key, node);
        
        freqMap.get(currFreq).remove(key);
        
        int newFreq = currFreq+1;

        if(currFreq == minFreq && freqMap.get(currFreq).isEmpty()) {
            minFreq = newFreq;
        }
        
        Set<Integer> freqKeys = freqMap.get(newFreq);        

        if(freqKeys == null) {
            freqKeys = new LinkedHashSet<>();
        }

        freqKeys.add(key);
        freqMap.put(newFreq, freqKeys);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            node.val = value;
            map.put(key, node);
            get(key);
        } else {
            if(map.size() == cap) {
                int remove = freqMap.get(minFreq).iterator().next();
                map.remove(remove);
                freqMap.get(minFreq).remove(remove);
            }
            Node newNode = new Node(value, 1);
            map.put(key, newNode);

            Set<Integer> freqKeys = freqMap.get(1);
            freqKeys.add(key);
            freqMap.put(1, freqKeys);
            minFreq=1;
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */