class Node {
    int key;
    int val;
    Node next;
    Node prev;
}

class LRUCache {
    int cap;
    Map<Integer, Node> map;
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(cap);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node currNode = map.get(key);
            removeLast(currNode);
            addFirst(currNode);
            return currNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            node.val = value;
            removeLast(node);
            addFirst(node);
        } else {
            if(map.size() == cap) {
                map.remove(tail.prev.key);
                removeLast(tail.prev);
            }

            Node newNode = new Node();
            newNode.val = value;
            newNode.key = key;

            map.put(key, newNode);
            addFirst(newNode);
        }
    }

    public void addFirst(Node node) {
        Node headNext = head.next;
        node.prev = head;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
    }

    public void removeLast(Node node) {
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