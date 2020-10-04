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
class Solution {   //19ms 25%
    public boolean isEvenOddTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int level = 0;
        int prev = -1;
        queue.offer(new Pair(root, level));
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek().getValue() == level) {
                Pair<TreeNode, Integer> tmp = queue.poll();
                if (level % 2 == 0) {
                    if (tmp.getKey().val % 2 == 0 || (prev != -1 &&  prev >= tmp.getKey().val))
                        return false;
                    else
                        prev = tmp.getKey().val;
                        
                } else {
                    if (tmp.getKey().val % 2 != 0 || (prev != -1 && prev <= tmp.getKey().val))
                        return false;
                    else
                        prev = tmp.getKey().val;                    
                }
                
                if (tmp.getKey().left != null) {
                    queue.offer(new Pair(tmp.getKey().left, level + 1));
                }
                if (tmp.getKey().right != null) {
                    queue.offer(new Pair(tmp.getKey().right, level + 1));
                }
            }
            prev = -1;
            level++;
        }
        
        return true;
        
    }
}