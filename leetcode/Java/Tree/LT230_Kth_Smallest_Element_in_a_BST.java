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
class Solution {  // 0ms 100% inorder traverse time O(n) space O(n) dfs
  public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) return arr;
    inorder(root.left, arr);
    arr.add(root.val);
    inorder(root.right, arr);
    // System.out.println("size: " + arr.size());
    // System.out.println("root: " + root.val);
    // for (Integer e : arr)
    //     System.out.print(e + " ");
    // System.out.println();
    return arr;
  }

  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
    return nums.get(k - 1);
  }
}


/*
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1


size: 2
root: 2
1 2 
size: 2
root: 1
1 2 
size: 4
root: 4
1 2 3 4 
size: 4
root: 3
1 2 3 4 
*/