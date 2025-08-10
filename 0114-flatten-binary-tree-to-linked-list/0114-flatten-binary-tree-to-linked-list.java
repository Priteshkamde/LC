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
    // O(N)
    // constant
    public void flatten(TreeNode root) {
        
        TreeNode curr = root;
        TreeNode prev = null;
        
        while(curr != null){
            if(curr.left != null) {
                prev = curr.left;
                
                // go rightmost
                while(prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;

            }
              
        // no left - then directly go to right
        curr = curr.right;
        }
    }
}