package leetcodePractice;
import java.util.*;
import java.util.Map.Entry;

public class FirstNonRepeatingCharacterInString {
	public char firstNonRepeatingCharacterInString (String str) {
		HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() == 1)
				return e.getKey();
		}
		return '<';
	}
}
