package leetcodePractice;
/*
Difficulty: Easy
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
 */
public class PaintFence {
	/*
    You can use any of the k colors for the third, but if it's the same color as the second post, 
    then this color must be one of the k-1 not used for the first post. And if it's not the same 
    color as the second post, then it must be one of the k-1 not used for the second post.
    */
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        int p1, p2, curr;
        p1 = k;
        p2 = k * k;
        curr = 0;
        if (n == 1)
            return p1;
        else if (n == 2)
            return p2;
        for (int i = 2; i < n; i++) {
            curr = (k - 1) * (p1 + p2);
            p1 = p2;
            p2 = curr;
        }
        return curr;
    }
}
