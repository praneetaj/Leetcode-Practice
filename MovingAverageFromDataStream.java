/*

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/

public class MovingAverage {
    List<Integer> nums;
    int size;
    double total;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.nums = new ArrayList<Integer>();
        total = 0;
        this.size = size;
    }
    
    public double next(int val) {
        if (nums.size() == this.size) {
            total -= nums.get(0);
            nums.remove(0);
        }
        nums.add(val);
        total += val;
        return total / nums.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */