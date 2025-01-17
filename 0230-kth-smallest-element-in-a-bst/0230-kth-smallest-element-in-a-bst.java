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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result = new ArrayList();
        kSMall(root, result);
        System.out.println(result);
        return result.get(k-1);
    }

    public void kSMall(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return;
        kSMall(root.left, result);
        result.add(root.val);
        kSMall(root.right, result);
    }
}