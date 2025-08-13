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
    // Tc -> O(N)
    // Sc -> O(N)
    // N is number of all nodes in tree
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return Collections.EMPTY_LIST;

        List<List<Integer>> result = new ArrayList<>();
        // a level = 0
        // BFS with Q
        // CHECK and push Left and Right elements in queue
        // if level is odd we add 
        // else we even -> we reverse it
        // keep adding to result
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<Integer> tempResult;
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            tempResult = new ArrayList<>();
            for(int i = 0 ; i < size ; i++) {
                TreeNode node = q.poll();
                tempResult.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            if(level%2 != 0) {
                Collections.reverse(tempResult);
            }
            result.add(tempResult);
            level+=1;
        }

        return result;
    }
}