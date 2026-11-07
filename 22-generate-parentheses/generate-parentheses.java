class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        fun(n, 0, 0, "", ans);

        return ans;
    }

    void fun(int n, int open, int close, String s, List<String> ans) {

        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        // Include opening bracket
        if (open < n) {
            fun(n, open + 1, close, s + "(", ans);
        }

        // Include closing bracket
        if (close < open) {
            fun(n, open, close + 1, s + ")", ans);
        }
    }
}