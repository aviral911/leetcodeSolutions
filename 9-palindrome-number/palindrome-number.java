class Solution {
    public boolean isPalindrome(int x) {
        int orr = x;
        int s=0;
       
          if (x < 0) {
            return false;
        }
        while(x>0){
           int n = x % 10;
            s = s*10+n;
            x=x/10;
        }
       
        return s==orr;
    }
}