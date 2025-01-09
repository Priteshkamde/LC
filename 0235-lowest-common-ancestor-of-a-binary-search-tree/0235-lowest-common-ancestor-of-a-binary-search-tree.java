/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // if both the nodes are greater than root, then search in Right
        if( p.val > root.val && q.val > root.val ) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // if both the nodes are less than root, then search in Left
        if( p.val < root.val && q.val < root.val ) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // neither then its exactly in between or either of them
        else {
          return root;  
        } 
        
    }
}