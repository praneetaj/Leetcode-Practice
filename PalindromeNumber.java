/*
Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int temp = x;
        int divisor = 1;
        while (temp >= 10) {
            temp = temp / 10;
            divisor = divisor * 10;
        }
        while (divisor > 1) {
            if ((x / divisor) != (x % 10))
                return false;
            x = (x % divisor) / 10;
            divisor = divisor / 100;
        }
        return true;
    }
}