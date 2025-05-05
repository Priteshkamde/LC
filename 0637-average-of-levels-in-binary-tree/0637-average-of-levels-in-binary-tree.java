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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> result = new ArrayList<>(); 
        List<Double> list;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++) {
                TreeNode node = q.poll();
                list.add((double) node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }

            result.add(getAvg(list));
        }   

        return result;
    }

    public Double getAvg(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).sum()/list.size();
    }
}