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
class Solution { // 1ms 43.92% preorder traverse
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        traverse(root, q);
        TreeNode rt = q.poll();
        TreeNode t = rt;
        int size = q.size();
        for (int i = 0; i < size; ++i) {
            TreeNode tmp = q.poll();
            t.right = tmp;
            t.left = null;
            t = t.right;       
        }
    }
    public void traverse(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) return;
        queue.add(root);
        if (root.left != null)
            traverse(root.left, queue);
        if (root.right != null)
            traverse(root.right, queue);
    }
}