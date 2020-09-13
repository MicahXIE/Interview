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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        
        traversal(root, res);
        return res;
    }
    private void traversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                traversal(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                traversal(root.right, res); 
            }
        }     
    }
}