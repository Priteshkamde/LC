class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> nodeMap = new HashMap<>();
    int cache_capacity;

    public LRUCache(int capacity) {
        this.cache_capacity = capacity;
        nodeMap = new HashMap(cache_capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = nodeMap.get(key);
        if(node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }
    
    public void put(int key, int value) {

        // check if exists in map
        Node node = nodeMap.get(key);
        if(node != null){
            remove(node);
            node.val = value;
            add(node);
        }

        else {
            if(nodeMap.size() == cache_capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            nodeMap.put(key, newNode);
            add(newNode);
        }
        
    }

    // adds front 
    public void add(Node node){
        Node headNext = head.next;
        head.next = node;
        node.prev = head;

        node.next = headNext;
        headNext.prev = node;
    }

    // remove node
    public void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */