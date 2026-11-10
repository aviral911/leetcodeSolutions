class Solution {
    public boolean isPalindrome(int x) {
       int a =x;
       if(a==0){
        return true;
       }
       int rev =0;
       int n =0;
       while(a>0){
        n=a%10;
      rev = rev * 10 + n;
 a=a/10;
       }
       if(rev==x){ return true;}
       return  false;
    }
}