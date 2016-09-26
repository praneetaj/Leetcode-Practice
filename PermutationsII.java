/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

public class Solution {
    HashSet<List<Integer>> set;
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new LinkedList<List<Integer>>();
        if (nums.length == 0)
            return result;
        set = new HashSet<List<Integer>>();
        List<Integer> sub = new LinkedList<Integer>();
        sub.add(nums[0]);
        permuteUnique(nums, 1, sub);
        return result;
    }
    
    public void permuteUnique(int[] nums, int index, List<Integer> sub) {
        if (index == nums.length) {
            if (!set.contains(sub)) {
                set.add(sub);
                result.add(sub);
            }
            return;
        }
        for (int j = 0; j <= sub.size(); j++) {
            List<Integer> temp = new LinkedList<Integer>(sub);
            temp.add(j, nums[index]);
            permuteUnique(nums, index + 1, temp);
        }
    }
}