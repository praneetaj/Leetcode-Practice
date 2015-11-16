package leetcodePractice;

/*
Difficulty: Easy
A strobogrammatic number is a number that looks the same when rotated 180 degrees 
(looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is 
represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        if (num.length() < 1)
            return true;
        int left, right;
        left = 0;
        right = num.length() - 1;
        while (left <= right) {
            char l, r;
            l = num.charAt(left);
            r = num.charAt(right);
            if ((left == right) && (l == '1' || l == '8' || l == '0'))
                return true;
            if ((l == '1' && r == '1') || (l == '6' && r =='9') || 
            (l == '9' && r =='6') || (l == '8' && r == '8') || (l == '0' && r =='0')) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }
}
