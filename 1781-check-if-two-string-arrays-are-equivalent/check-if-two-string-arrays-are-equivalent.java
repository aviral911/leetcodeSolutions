class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";

        for (String str : word1) {
            s1 += str;
        }

        for (String str : word2) {
            s2 += str;
        }

        return s1.equals(s2);
    }
}