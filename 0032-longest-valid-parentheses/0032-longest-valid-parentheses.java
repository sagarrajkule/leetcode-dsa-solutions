class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, maxLen = 0;

        // First Pass: Left to Right
        // This handles patterns like "(()())"
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++; // count opening brackets
            } else {
                close++; // count closing brackets
            }

            // When we have a balanced pair
            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close); // update max length
            }
            // If closing brackets exceed opening, reset counters
            else if (close > open) {
                open = close = 0;
            }
        }

        // Second Pass: Right to Left
        // This handles patterns like "())(()"
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == ')') {
                close++; // count closing brackets
            } else {
                open++; // count opening brackets
            }

            // When we have a balanced pair
            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open); // update max length
            }
            // If opening brackets exceed closing, reset counters
            else if (open > close) {
                open = close = 0;
            }
        }

        // Final result is stored in maxLen
        return maxLen;
    }
}
