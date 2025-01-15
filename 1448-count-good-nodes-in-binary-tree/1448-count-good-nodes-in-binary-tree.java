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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
    public int countGoodNodes(TreeNode root, int max){
        if(root == null) return 0;

        int curr = (root.val >= max) ? 1 : 0;

        max = Math.max(max, root.val);

        curr += countGoodNodes(root.right, max);

        curr += countGoodNodes(root.left, max);

        return curr;
    }
}