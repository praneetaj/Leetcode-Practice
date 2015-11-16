package leetcodePractice;

/*
Difficulty: Easy
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 */

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if (s == null || s.length() < 2)
            return true;
        for (int i = 0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        if (s.length() % 2 == 0) {
            for (int cnt : map.values())
                if (cnt % 2 != 0)
                    return false;
        } else {
            boolean flag = false;
            for (int cnt : map.values()) {
                if (cnt % 2 != 0 && !flag)
                    flag = true;
                else if (cnt % 2 != 0 && flag)
                    return false;
            }
        }
        return true;
    }
}
