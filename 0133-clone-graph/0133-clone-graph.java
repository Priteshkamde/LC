/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node cloneUtil(Node node, Map<Node, Node> map) {
        // create a newNode with input value
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node neighbor : node.neighbors) {
            if(!map.containsKey(neighbor)) {
                // not cloned and create a new one here
                newNode.neighbors.add(cloneUtil(neighbor, map));
            } else {
                // its already cloned, so only append its neighbors by pulling from hashmap
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if( node == null )
            return null;
        Map<Node, Node> map = new HashMap<>();
        return cloneUtil(node, map);
    }
}