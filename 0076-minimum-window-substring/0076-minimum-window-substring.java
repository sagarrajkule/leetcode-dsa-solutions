import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        // Step 1: Build frequency map for characters in t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window pointers and required variables
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Number of unique characters in t that must be present in the window
        int required = tFreq.size();
        int formed = 0;

        // Frequency map for current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Check if current character frequency matches the one in t
            if (tFreq.containsKey(c) && windowCounts.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window till it's no longer valid
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);

                if (tFreq.containsKey(leftChar)
                        && windowCounts.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}