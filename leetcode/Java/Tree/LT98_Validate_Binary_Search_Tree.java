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
class Solution {    // 1ms 42.67%
    public boolean isValidBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        valid(root, lst);
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i - 1) >= lst.get(i))
                return false;
        }
        
        return true;
    }
    private void valid(TreeNode root, List<Integer> lst) {
        if (root == null) return;
        if (root.left != null) 
            valid(root.left, lst);
        lst.add(root.val);
        if (root.right != null) 
            valid(root.right, lst);            
    }
}