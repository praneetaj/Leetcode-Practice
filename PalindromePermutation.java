    package leetcodePractice;

/*
Difficulty: Easy
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 */

public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        int count = 0;
        for (int i : map.values()) {
            if (i % 2 != 0) {
                count++;
            }
        }
        if (count == 0)
            return true;
        else if (count == 1)
            return s.length() % 2 != 0;
        return false;
    }
}
