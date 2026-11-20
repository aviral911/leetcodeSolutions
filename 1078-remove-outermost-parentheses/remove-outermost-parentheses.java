class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!st.isEmpty()) str.append(ch);
                st.push(ch);
            } else {
                st.pop();
                if (!st.isEmpty()) str.append(ch);
            }
        }
        return str.toString();
    }
}