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
class Solution { // 1ms 81.97%
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        int layer = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> lst = new ArrayList<Integer>();
            Stack<TreeNode> st = new Stack<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                st.push(node);
                lst.add(node.val);
            }
            res.add(lst);
            if (layer % 2 == 0) {
                 while (!st.isEmpty()) {
                    TreeNode tn = st.pop();
                    if (tn.right != null)
                        queue.add(tn.right);
                    if (tn.left != null)
                        queue.add(tn.left);
                }
            } else {
                while (!st.isEmpty()) {
                    TreeNode tn = st.pop();
                    if (tn.left != null)
                        queue.add(tn.left);  
                    if (tn.right != null)
                        queue.add(tn.right);
                }
            }
            layer++;
        }
        return res;
    }
}