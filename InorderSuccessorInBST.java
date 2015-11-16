package leetcodePractice;
/*
Difficulty: Medium
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
 */

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p==null || root==null)
            return null;
        if (p.right != null) {
            TreeNode temp = p.right;
            while (temp.left != null)
                temp = temp.left;
            return temp;
        } else {
            TreeNode temp = root;
            TreeNode succ = null;
            while (temp != null) {
                if (temp.val > p.val) {
                    succ = temp;
                    temp = temp.left;
                } else
                    temp = temp.right;
            }
            return succ;
        }
    }
}
