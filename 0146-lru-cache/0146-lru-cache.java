class Node {
    int key;
    int val;
    Node next;
    Node prev;
}

class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    final Node head = new Node();
    final Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            add(newNode);
            map.put(key, newNode);
        }
    }

    private void add(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        node.prev = head;
        head.next = node;
        headNext.prev = node;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
