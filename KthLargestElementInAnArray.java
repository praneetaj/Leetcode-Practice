/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, nums.length - k, 0, nums.length - 1);
    }
    
    public int findKthSmallest(int[] nums, int k, int begin, int end) {
        if (begin > end)
            return -1;
        int pos = partition(nums, begin, end);
        if (pos > k)
            return findKthSmallest(nums, k, begin, pos - 1);
        else if (pos == k)
            return nums[pos];
        else
            return findKthSmallest(nums, k, pos + 1, end);
    }
    
    private int partition(int[] nums, int start, int end) {
        if (start > end)
            return -1;
        if (start == end)
            return start;
        int i, curr, pivot;
        i = start;
        pivot = nums[end];
        for (curr = start; curr < end; curr++) {
            if (nums[curr] <= pivot) {
                if (i != curr) {
                    int temp = nums[i];
                    nums[i] = nums[curr];
                    nums[curr] = temp;
                }
                i++;
            }
        }
        int temp1 = nums[i];
        nums[i] = nums[end];
        nums[end] = temp1;
        return i;
    }
}