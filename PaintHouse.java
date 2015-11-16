package leetcodePractice;
/*
Difficulty: Medium
There are a row of n houses, each house can be painted with one of the three colors: 
red, blue or green. The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost 
matrix. For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... Find the 
minimum cost to paint all houses.

Note:
All costs are positive integers.
 */
public class PaintHouse {
	public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int w = costs[0].length;
        int[] prev = new int[w];
        for (int[] cc : costs) {
            int[] curr = new int[w];
            for (int i=0; i<w; i++) {
                curr[i] = cc[i] + Math.min(prev[((i+1)%3)], prev[((i+2)%3)]);
            }
            prev = curr;
        }
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
}
