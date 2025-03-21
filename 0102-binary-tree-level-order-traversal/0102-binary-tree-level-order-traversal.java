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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int N = q.size();
            List<Integer> list = new ArrayList<Integer>();

            for(int i = 0 ; i < N ; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if( node.left != null ) q.add(node.left);
                if( node.right != null ) q.add(node.right);
            }
            result.add(list);
        }
    return result;
    }   
}