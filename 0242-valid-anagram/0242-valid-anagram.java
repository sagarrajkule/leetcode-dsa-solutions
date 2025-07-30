import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they can't be anagrams
        if (s.length() != t.length()) return false;

        Map<Character, Integer> charCount = new HashMap<>();

        // Count frequency of each character in string s
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Subtract frequency using string t
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false; // Character mismatch
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        // All character counts matched
        return true;
    }
}
