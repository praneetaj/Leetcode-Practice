/*
Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    Set<List<Integer>> set = new HashSet<List<Integer>>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        result.add(sub);
        subsetsWithDup(nums, 0, sub, result);
        return result;
    }
    
    public void subsetsWithDup(int[] nums, int index, List<Integer> sub, List<List<Integer>> result) {
        if (index >= nums.length)
            return;
        List<Integer> temp = new ArrayList<Integer>(sub);
        temp.add(nums[index]);
        if (!set.contains(temp)) {
            result.add(temp);
            set.add(temp);
        }
        subsetsWithDup(nums, index + 1, sub, result);
        sub.add(nums[index]);
        subsetsWithDup(nums, index + 1, sub, result);
        sub.remove(sub.size() - 1);
    }
}