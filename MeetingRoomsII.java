package leetcodePractice;

/*
Difficulty: Medium
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new IntervalComparator());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= minHeap.peek())
                minHeap.poll();
            minHeap.add(intervals[i].end);
        }
        return minHeap.size();
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare (Interval i1, Interval i2) {
        return (i1.start - i2.start);
    }
}
