import java.util.*;

public class Solution {
    public String minWindow(String source, String target) {
        int sourceLength = source.length();
        int targetLength = target.length();
        if (sourceLength < targetLength || sourceLength == 0 || targetLength == 0)
            return "";

        int[] charFrequency = new int[256]; // Frequency of characters in target

        // Count each character in target string
        for (int i = 0; i < targetLength; i++) {
            charFrequency[target.charAt(i)]++;
        }

        int left = 0, right = 0;
        int matchedCharacters = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int windowStartIndex = -1;

        while (right < sourceLength) {
            char currentChar = source.charAt(right);
            charFrequency[currentChar]--;

            if (charFrequency[currentChar] >= 0) {
                matchedCharacters++;
            }

            // Shrink the window as long as it contains all characters from target
            while (matchedCharacters == targetLength) {
                // Update the smallest window
                if ((right - left + 1) < minWindowLength) {
                    minWindowLength = right - left + 1;
                    windowStartIndex = left;
                }

                // Try to move left pointer forward to minimize the window
                char leftChar = source.charAt(left);
                charFrequency[leftChar]++;
                if (charFrequency[leftChar] > 0) {
                    matchedCharacters--;
                }
                left++;
            }

            right++;
        }

        return windowStartIndex == -1
                ? ""
                : source.substring(windowStartIndex, windowStartIndex + minWindowLength);
    }
}
