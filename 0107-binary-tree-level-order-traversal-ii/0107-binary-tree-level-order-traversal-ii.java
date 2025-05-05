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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)    
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        List<Integer> list;
        q.add(root);

        while(!q.isEmpty()) {
            list = new ArrayList<>();
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode t = q.poll();
                list.add(t.val);
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
            }
            result.add(0,list);
        }

        return result;
    }
}