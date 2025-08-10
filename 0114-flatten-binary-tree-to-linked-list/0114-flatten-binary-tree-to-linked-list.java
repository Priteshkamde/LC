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
    // Tc N and Sc N
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();

            if(node.right != null)
                stack.push(node.right);
            
            if(node.left != null)
                stack.push(node.left);

            if(!stack.isEmpty()){
                node.right = stack.peek();
            }

            node.left = null;    
        }
    }
}