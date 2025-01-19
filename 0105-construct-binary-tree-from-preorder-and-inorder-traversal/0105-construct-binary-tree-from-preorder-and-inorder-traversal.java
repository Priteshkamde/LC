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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // create a hashmap for inorder with its indices
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < inorder.length ; i++) {
            hashmap.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, preorder.length-1,
                        inorder, 0 , inorder.length-1,
                        hashmap);                
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
        int[] inorder, int inorderStart, int inorderEnd,
        HashMap<Integer, Integer> hashmap){

            if(preorderStart > preorderEnd || inorderStart>inorderEnd) return null;
                    
            // start from building the root from preorder
            TreeNode root = new TreeNode(preorder[preorderStart]);

            // locate the preorders element in inorder hashmap
            int inorderRootIndex = hashmap.get(root.val);

            // determine the numbers on left
            int numsLeft = inorderRootIndex - inorderStart;

            root.left = buildTree(preorder, preorderStart+1, preorderStart+numsLeft,
                        inorder, inorderStart , inorderRootIndex-1,
                        hashmap);
            root.right = buildTree(preorder, preorderStart+numsLeft+1, preorderEnd,
                        inorder, inorderRootIndex+1 , inorderEnd,
                        hashmap);

            return root;
    }
    
}