class Node{
    int key;
    int val;
    Node next;
    Node prev;
}

class LRUCache {

    Map<Integer, Node> map;  
    int cap;
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(cap);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        if(!map.containsKey(key)) {
            return result;
        }
        Node node = map.get(key);
        result = node.val;
        remove(node);
        add(node);
        return result;
    }
    
    public void put(int key, int value) {

        // check if present
        if(map.containsKey(key)) {
            Node node = map.get(key);
            // update its value
            node.val = value;
            // update in map
            map.put(key, node);
            // move it front
            remove(node);
            add(node);
        }

        // if a new key
        else {
            // check for capacity
            if(map.size() == cap) {
                // remove the last 
                // and add the new one in the front
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.val = value;
            newNode.key = key;
            add(newNode);
            map.put(key, newNode);
        }
    }

    public void add(Node node){
        Node headNext = head.next;
        node.prev = head;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
    }

    public void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */