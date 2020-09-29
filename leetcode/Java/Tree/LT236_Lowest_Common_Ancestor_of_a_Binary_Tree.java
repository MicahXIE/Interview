class Solution {  // 9ms 29.49% time O(n) space O(n)

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // use ArrayDeque to replace Stack
        Deque<TreeNode> stack = new ArrayDeque<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        
        stack.push(root);
        parent.put(root, null);
        //preorder traverse
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q; 
    }

}