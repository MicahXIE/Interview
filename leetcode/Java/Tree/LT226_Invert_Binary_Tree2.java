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
class Solution {  // 0ms time O(n) 
	public TreeNode invertTree(TreeNode root) {
    	if (root == null) {
	        return null;
    	}
    	TreeNode right = invertTree(root.right);
    	TreeNode left = invertTree(root.left);
    	// if (root != null) System.out.println("root: " + root.val);
    	// else System.out.println("root: null");
    	// if (right != null) System.out.println("right: " + right.val); 
    	// else System.out.println("right: null");
    	// if (left != null) System.out.println("left: " + left.val);
    	// else System.out.println("left: null");
    	System.out.println();
    	
    	   
    	root.left = right;
    	root.right = left;
    	return root;
	}
}
/*
 	 4
   /   \
  2     7
 / \   / \
1   3 6   9

root: 9
right: null
left: null

root: 6
right: null
left: null

root: 7
right: 9
left: 6

root: 3
right: null
left: null

root: 1
right: null
left: null

root: 2
right: 3
left: 1

root: 4
right: 7
left: 2

*/




