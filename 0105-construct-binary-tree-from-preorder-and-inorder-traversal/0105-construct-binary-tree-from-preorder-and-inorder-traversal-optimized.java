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

    private int pre=0;
    private int in=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MIN_VALUE);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int stop){
        if(pre>=preorder.length){
            return null;
        }
        if(inorder[in]==stop){
            in++;
            return null;
        }
        TreeNode node=new TreeNode(preorder[pre++]);
        node.left=buildTree(preorder, inorder, node.val);
        node.right=buildTree(preorder, inorder, stop);
        return node;
    }
    
}