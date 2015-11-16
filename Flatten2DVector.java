package leetcodePractice;

/*
Difficulty: Medium
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order 
of elements returned by next should be: [1,2,3,4,5,6].

Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */

public class Flatten2DVector {
	Iterator<List<Integer>> all;
    Iterator<Integer> curr;

    public Vector2D(List<List<Integer>> vec2d) {
        this.all = vec2d.iterator();
        if (all.hasNext())
            curr = all.next().iterator();
        else curr = null;
    }

    public int next() {
        return curr.next();
    }

    public boolean hasNext() {
        if (curr != null && curr.hasNext())
            return true;
        else  {
            while (all.hasNext()) {
                curr = all.next().iterator();
                if (curr.hasNext())
                    return true;
            }
            return false;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */