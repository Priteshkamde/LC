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
    public boolean isBalanced(TreeNode root) {
        if(root == null) 
            return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        System.out.println(left);
        System.out.println(right);
        if(Math.abs(left-right) > 1)    
            return false;
            
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if(root == null) 
            return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return Math.max(lh,rh)+1;
    }
}