package leetcodePractice;

/*
Difficulty: Hard
There is a new alien language which uses the latin alphabet. However, the 
order among letters are unknown to you. You receive a list of words from 
the dictionary, where words are sorted lexicographically by the rules of 
this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */

public class AlienDictionary {
	public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        HashMap<Character, Integer> degree = new HashMap<Character, Integer>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++)
                degree.put(words[i].charAt(j), 0);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> s = new HashSet<Character>();
                    if (map.containsKey(c1))
                        s = map.get(c1);
                    if (!s.contains(c2)) {
                        s.add(c2);
                        map.put(c1, s);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<Character>();
        for (char i : degree.keySet()) {
            if (degree.get(i) == 0)
                q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.remove();
            sb.append(c);
            if (map.containsKey(c)) {
                for (char t : map.get(c)) {
                    degree.put(t, degree.get(t) - 1);
                    if (degree.get(t) == 0)
                        q.add(t);
                }
            }
        }
        if(sb.length()!=degree.size()) return "";
        return sb.toString();
    }
}
