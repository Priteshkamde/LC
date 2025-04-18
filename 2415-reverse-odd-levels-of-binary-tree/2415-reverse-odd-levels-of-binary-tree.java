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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int level = 0;

        q.add(root);
        List<TreeNode> list;

        while(!q.isEmpty()) {
            int N = q.size();
            list = new ArrayList<>();
            for(int i = 0 ; i < N ; i++) {
                TreeNode node = q.poll();
                list.add(node);
                if(node.left != null)
                    q.add(node.left);
                
                if(node.right != null)
                    q.add(node.right);
            }

            // odd level
            if(level % 2 == 1) {
                // reverse an array
                for(int i = 0 ; i < N/2 ; i++) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(N-i-1).val;
                    list.get(N-i-1).val = temp;
                } // swapping each element
            }
            level++;
        }

        return root;
    }
}