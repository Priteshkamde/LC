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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = new int[1];
        height(root, dia);
        return dia[0];
    }
    public int height(TreeNode root, int[] dia) {
        if(root == null) 
            return 0;
        
        int leftH = height(root.left, dia);
        int rightH = height(root.right, dia);

        dia[0] = Math.max(leftH+rightH, dia[0]);

        return 1 + Math.max(leftH, rightH);
    }
}