import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Edge case: null or odd-length string can't be valid
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // Push opening brackets to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty, no opening bracket to match
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop from stack and check for matching pair
                char top = stack.pop(); // or char top = stack.peek();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched correctly
        return stack.isEmpty();
    }
}
