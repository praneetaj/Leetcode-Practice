/*

Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pathSum(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> result) {
        if (root == null)
            return;
        
        curr.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<Integer>(curr));
        } else {
            pathSum(root.left, sum - root.val, curr, result);
            pathSum(root.right, sum - root.val, curr, result);
        }
        
        curr.remove(curr.size() - 1);
    }
}