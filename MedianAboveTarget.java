package leetcodePractice;

public class MedianAboveTarget {
	public double findMedianAboveTarget(int nums[], int target) {
		int index = binarySearch(nums, 0, nums.length-1, target, -1);
		if (index == -1)
			return -1;
		else if ((nums.length - index) % 2 == 0) {
			int j = index+(nums.length -1 - index)/2;
			return (nums[j] + nums[j+1])*0.5;
		} else {
			int j = index+(nums.length -1 - index)/2;
			return (nums[j]);
		}
		
	}
	
	public int binarySearch(int[] nums, int start, int end, int target, int minIndex) {
		if (start > end)
			return minIndex;
		if (target > nums[end])
			return minIndex;
		int mid = (start+end)/2;
		if (nums[mid] >= target) {
			if (minIndex == -1) {
				minIndex = mid;
			} else {
				minIndex = Math.min(minIndex,  mid);
			}
			return binarySearch(nums, start, mid-1, target, minIndex);
		} else {
			return binarySearch(nums, mid+1, end, target, minIndex);
		}
	}
}
