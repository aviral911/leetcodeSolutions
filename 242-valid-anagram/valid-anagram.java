class Solution {
    public boolean isAnagram(String s, String t) {
        int f1[]=new int[26];
        for(char ch:s.toCharArray()){
            f1[ch - 'a']++;
        }
        int f2[]=new int[26];
        for(char ch:t.toCharArray()){
            f2[ch - 'a']++;
        }
        return Arrays.equals(f1,f2);
    }
}