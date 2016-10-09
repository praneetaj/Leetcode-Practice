/*
Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        // From right to left, find the index, p such that nums[p] < nums[p + 1]
        int p = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        
        // From right to left, find the first index, q such that nums[p] < nums[q]
        int q = 0;
        for (int i = nums.length - 1; i > p; i--) {
            if (nums[p] < nums[i]) {
                q = i;
                break;
            }
        }
        
        if (p == 0 && q == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
        reverse(nums, p + 1, nums.length - 1);
    }
    
    private void reverse(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}