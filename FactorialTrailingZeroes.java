/*
Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
    public int trailingZeroes(int n) {
        if (n <= 0) 
            return 0;
        int cnt = 0;
        while (n > 0) {
            cnt = cnt + (n / 5);
            n = n / 5;
        }
        return cnt;
    }
}