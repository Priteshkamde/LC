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
    public boolean isSymmetric(TreeNode root) {

        if(root == null)
            return true;
            
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();

            if(l == null && r == null) {
                continue;
            }

            if(l == null || r == null || l.val != r.val) {
                return false;
            }

            q.add(l.left);
            q.add(r.right);
            q.add(l.right);
            q.add(r.left);
        }

        return true;
    
    }
}