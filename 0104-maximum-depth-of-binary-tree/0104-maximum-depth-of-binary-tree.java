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
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        if (root.right == null && root.left == null) return 1;

        return Math.max(maxD(root.left, 1), maxD(root.right, 1));
    }

    public int maxD(TreeNode root, int count) {
        if (root == null) return count;        
        return Math.max(maxD(root.right, count+1), maxD(root.left, count+1)) ;
    }
}