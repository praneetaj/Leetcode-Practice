package leetcodePractice;
/*
Difficulty: Medium
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ;
        if (p.right != null) {
            succ = p.right;
            while (succ.left != null)
                succ = succ.left;
        } else {
            succ = null;
            TreeNode temp = root;
            while (temp != null) {
                if (temp.val == p.val) {
                    break;
                } else if (temp.val > p.val) {
                    succ = temp;
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }
        return succ;
    }
}