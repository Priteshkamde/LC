/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple {
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode n, int v, int l) {
        node = n;
        vertical = v;
        level = l;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.vertical;
            int y = t.level;

            map.computeIfAbsent(x, k -> new TreeMap<>());
            map.get(x).computeIfAbsent(y, k -> new ArrayList<>());
            map.get(x).get(y).add(node.val); // Keep BFS insertion order

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> nodes : levelMap.values()) {
                col.addAll(nodes); // BFS order preserved
            }
            list.add(col);
        }

        return list;
    }
}
