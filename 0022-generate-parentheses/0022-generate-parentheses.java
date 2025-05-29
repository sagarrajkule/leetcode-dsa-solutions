class Solution {
    void Helper(List<String> ans, int open, int close, int n, String temp) {
        // Base condition
        if (open == close && temp.length() == n * 2) { // E.g. If N=2, no. of paranthesis/brackets will be 4. thats why N * 2. 
            ans.add(temp);
            return;
        }

        // Add open bracket
        if (open < n) {
            Helper(ans, open + 1, close, n, temp + "(");
        }

        // Add close bracket
        if (open > close) {
            Helper(ans, open, close + 1, n, temp + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Helper(ans, 0, 0, n, "");

        return ans;
    }
}