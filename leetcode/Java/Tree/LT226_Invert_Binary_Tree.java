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
class Solution { // 0ms 100% time O(n) space O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null)
                swap(t);
            if (t.left != null) queue.add(t.left);
            if (t.right != null) queue.add(t.right);
        }
        return root;
        
    }
    public void swap(TreeNode t) {
        TreeNode tmp = t.left;
        t.left = t.right;
        t.right = tmp;
    }
}