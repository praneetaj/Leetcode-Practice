/*
Strobogrammatic Number

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        int left, right;
        left = 0;
        right = num.length() - 1;
        while (left <= right) {
            char l = num.charAt(left++);
            char r = num.charAt(right--);
            if ((l == '6' && r == '9') || (l == '9' && r == '6') || (l == '1' && r == '1') || (l == '0' && r == '0') || (l == '8' && r == '8'))
                continue;
            else
                return false;
        }
        return true;
    }
}