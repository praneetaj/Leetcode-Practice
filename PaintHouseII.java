package leetcodePractice;

/*
Difficulty: Hard
There are a row of n houses, each house can be painted with one of the k colors. 
The cost of painting each house with a certain color is different. You have to 
paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k 
cost matrix. For example, costs[0][0] is the cost of painting house 0 with 
color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
 */

public class PaintHouseII {
	public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int w = costs[0].length;
        int pmin1, pmin2, pind;
        pind = -1;
        pmin1 = pmin2 = 0;
        for (int[] cc : costs) {
            int cmin1, cmin2, cind, val;    //cmin1 is the least and cmin2 will be second least
            cmin1 = cmin2 = Integer.MAX_VALUE;
            cind = -1;
            for (int j=0; j<w; j++) {
                val = cc[j] + (j == pind ? pmin2 : pmin1);
                if (cind == -1) {
                    cmin1 = val;
                    cind = j;
                } else if (val < cmin1) {
                    cmin2 = cmin1;
                    cmin1 = val;
                    cind = j;
                } else if (val < cmin2)
                    cmin2 = val;
            }
            pmin1 = cmin1;
            pmin2 = cmin2;
            pind = cind;
        }
        return pmin1;
    }
}
