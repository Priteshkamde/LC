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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String pOrder = Serialize(p);
        String qOrder = Serialize(q);

        return qOrder.equals(pOrder);
    }

    private String Serialize(TreeNode root) {
        if(root == null)
            return " N";

        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }
}