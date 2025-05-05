/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// Tc - O(n)
class Solution {
    // public List<List<Integer>> levelOrder(Node root) {
    //     if (root == null)
    //         return new ArrayList<>();

    //     Queue<Node> q = new LinkedList<>();
    //     List<List<Integer>> result = new ArrayList<>();
    //     List<Integer> list;
    //     q.add(root);

    //     while (!q.isEmpty()) {
    //         int size = q.size();
    //         list = new ArrayList(); 
    //         for (int i = 0; i < size; i++) {
    //             Node n = q.poll();
    //             list.add(n.val);
    //             if(n.children != null) {
    //                 for(Node child : n.children) {
    //                     q.add(child);
    //                 }
    //             }
    //         }
    //         result.add(list);
    //     }

    //     return result;
    // }
    // rec
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            list = new ArrayList(); 
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                list.add(n.val);
                if(n.children != null) {
                    for(Node child : n.children) {
                        q.add(child);
                    }
                }
            }
            result.add(list);
        }

        return result;
    }
}
