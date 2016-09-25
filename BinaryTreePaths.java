/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        String sub = "";
        binaryTreePaths(root, sub, result);
        return result;
    }
    
    public void binaryTreePaths(TreeNode root, String sub, List<String> result) {
        if (root == null)
            return;
        sub = sub + root.val;
        if (root.left == null && root.right == null) {
            result.add(sub);
            return;
        }
        if (root.left != null)
            binaryTreePaths(root.left, sub + "->", result);
        if (root.right != null)
            binaryTreePaths(root.right, sub + "->", result);
    }
}