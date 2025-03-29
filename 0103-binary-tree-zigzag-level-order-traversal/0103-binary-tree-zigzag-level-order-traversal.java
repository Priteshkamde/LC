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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) 
            return Collections.emptyList();
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> tempList;
        Queue<TreeNode> q = new ArrayDeque<>();
        boolean reverse = false;

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            tempList = new LinkedList();
            while(size > 0) {
                TreeNode node = q.poll();
                if(reverse) {
                    tempList.addFirst(node.val);
                } else {
                    tempList.add(node.val);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                size--;
            }
            returnList.add(tempList);
            reverse = !reverse;
        }

        return returnList;
    }
}