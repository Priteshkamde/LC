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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null)
            return false;

        String rootString = preOrder(root);
        String subRootString = preOrder(subRoot);
        // System.out.println(rootString);
        // System.out.println(subRootString);
        return rootString.contains(subRootString);
    }

    public String preOrder(TreeNode root) {
        if(root == null) {
            return " null";
        }
        return " " + root.val + preOrder(root.left) + preOrder(root.right);
    }
}