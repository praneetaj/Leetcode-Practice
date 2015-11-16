package leetcodePractice;
/*
Difficulty: Easy
Given a non-empty binary search tree and a target value, find the value in the BST that is 
closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
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

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
        double difference = Double.MAX_VALUE;
        int value = 0;
        TreeNode cur = root;
        while (cur != null) {
            if (difference > Math.abs(cur.val - target)) {
                difference = Math.abs(cur.val - target);
                value = cur.val;
            }
            if (cur.val > target)
                cur = cur.left;
            else if (cur.val < target)
                cur = cur.right;
            else
                break;
        }
        return value;
    }
}
