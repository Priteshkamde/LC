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
        List<Integer> list = new ArrayList<>();

        inorder(root, list, k);
        System.out.println(list);
        return list.get(k-1);
    }

    public void inorder(TreeNode root, List<Integer> list, int k) {
        if(root == null) 
            return;
        
        if(list.size() == k)
            return;
        
        inorder(root.left, list, k);
        list.add(root.val);
        inorder(root.right, list, k);
    }
}