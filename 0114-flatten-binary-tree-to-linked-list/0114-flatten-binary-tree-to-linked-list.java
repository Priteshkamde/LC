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
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode curr = list.get(i);
            TreeNode next = list.get(i + 1);
            curr.left = null;
            curr.right = next;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root); // root
        preOrder(root.left, list); // left
        preOrder(root.right, list); // right
    }
}