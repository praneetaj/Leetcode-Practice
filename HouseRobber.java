/*

House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

*/

public class Solution {
    public int rob(int[] nums) {
        int prevMax, currMax;
        prevMax = currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
        
        /*
        // O(n) space solution
        
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }
        return money[nums.length - 1];
        */
    }
}