/*
Subsets

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/



public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        subsets(nums, 0, new ArrayList<Integer>(), result);
        result.add(new ArrayList<Integer>());
        return result;
    }
    
    public void subsets(int[] nums, int index, List<Integer> sub, List<List<Integer>> result) {
        if (index >= nums.length)
            return;
        List<Integer> temp = new ArrayList<Integer>(sub);
        temp.add(nums[index]);
        result.add(temp);
        subsets(nums, index + 1, sub, result);
        sub.add(nums[index]);
        subsets(nums, index + 1, sub, result);
        sub.remove(sub.size() - 1);
    }
}