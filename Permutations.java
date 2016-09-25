/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Solution {
    // Method 1
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0)
            return result;
        List<Integer> t = new ArrayList<Integer>();
        t.add(nums[0]);
        result.add(t);
        return permute(nums, 1, result);
    }
    
    public List<List<Integer>> permute(int[] nums, int i, List<List<Integer>> current) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (i >= nums.length)
            return current;
        for (int j = 0; j < current.size(); j++) {
            for (int k = 0; k <= i; k++) {
                List<Integer> temp = new ArrayList<Integer>(current.get(j));
                temp.add(k, nums[i]);
                result.add(temp);
            }
        }
        return permute(nums, ++i, result);
    } 
    
    /*
    // Method 2
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0)
            return result;
        List<Integer> t = new ArrayList<Integer>();
        t.add(nums[0]);
        permute(nums, 1, t, result);
        return result;
    }
    
    public void permute(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        List<List<Integer>> newresult = new ArrayList<List<Integer>>();
        if (index >= nums.length) {
            result.add(curr);
            return;
        }
        for (int j = 0; j <= curr.size(); j++) {
            List<Integer> temp = new ArrayList<Integer>(curr);
            temp.add(j, nums[index]);
            permute(nums, index + 1, temp, result);
        }
    }
    */
}