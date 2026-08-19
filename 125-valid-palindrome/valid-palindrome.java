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
       int j=s.length()-1;
       int i=0;
       while(i<j){
        if(s.charAt(i)!=s.charAt(j))
        return false;
        i++;j--;
       }
return true;
    }
}