package leetcodePractice;

/*
Difficulty: Medium
A strobogrammatic number is a number that looks the same when rotated 180 degrees 
(looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
 */

public class StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
        List<String> result = new LinkedList<String>();
        if (n == 0)
            return result;
        if (n % 2 == 0)
            result = findStrobogrammatic(n, "");
        else {
            result.addAll(findStrobogrammatic(n - 1, "0"));
            result.addAll(findStrobogrammatic(n - 1, "1"));
            result.addAll(findStrobogrammatic(n - 1, "8"));
        }
        return result;
    }
    
    public List<String> findStrobogrammatic(int n, String substring) {
        List<String> result = new LinkedList<String>();
        if (n <= 0) {
            result.add(substring);
            return result;
        }
        if (n != 2)
            result.addAll(findStrobogrammatic(n - 2, '0' + substring + '0'));
        result.addAll(findStrobogrammatic(n - 2, '8' + substring + '8'));
        result.addAll(findStrobogrammatic(n - 2, '1' + substring + '1'));
        result.addAll(findStrobogrammatic(n - 2, '6' + substring + '9'));
        result.addAll(findStrobogrammatic(n - 2, '9' + substring + '6'));
        return result;
    }
}
