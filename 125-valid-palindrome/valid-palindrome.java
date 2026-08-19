class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder ns=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'  || ch>='0' && ch<='9'){
                ns.append(ch);
            }
        }
        
        return checkPalin(ns.toString());
    }
    boolean checkPalin(String s){
        String rev= new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }
}