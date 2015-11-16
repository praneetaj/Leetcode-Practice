package leetcodePractice;

public class SortKSortedArray {
	int[] minHeap;
	int size;
	
	public SortKSortedArray(int k) {
		minHeap = new int[k+1];
		size = -1;
	}
	
	public void kSort (int[] nums, int k) {
		if (k == 0)
			return;
		int index = 0;
		int i;
		for (i = 0; i <= k; i++) {
			if (i > k)
				break;
			size++;
			insert(nums[i]);
		}
		System.out.println("size : "+size);
		if (i <= k+1) {
			i--;
			while (i < nums.length) {
				nums[index] = minHeap[0];
				delete();
				insert(nums[i]);
				i++;
				index++;
				System.out.println();
				for (int t = 0; t <= size; t++)
					System.out.print(minHeap[t] + " ");
			}
			index--;
		}
		while (size >= 0) {
			nums[index] = minHeap[size];
			delete();
			size--;
			index++;
		}
	}
	
	public void insert(int num) {
		minHeap[size] = num;
		int i = size;
		while (i > 0) {
			if (minHeap[i] < minHeap[parent(i)]) {
				int temp = minHeap[i];
				minHeap[i] = minHeap[parent(i)];
				minHeap[parent(i)] = temp;
			}
			i = parent(i);
		}
	}
	
	public void delete() {
		minHeap[0] = minHeap[size];
		size--;
		heapify(0);
	}
	
	public void heapify(int i) {
		if (i > size/2)
			return;
		int index = i;
		if (minHeap[i] > minHeap[left(i)])
			index = left(i);
		if (right(i) <= size && minHeap[index] > minHeap[right(i)])
			index = right(i);
		if (index != i) {
			int temp = minHeap[i];
			minHeap[i] = minHeap[index];
			minHeap[index] = temp;
			heapify(index);
		}
	}
	
	public int parent(int i) {
		if (i % 2 == 0)
			return i/2-1;
		else
			return i/2;
	}
	
	public int left(int i) {
		return i*2+1;
	}
	
	public int right(int i) {
		return i*2+2;
	}
}
