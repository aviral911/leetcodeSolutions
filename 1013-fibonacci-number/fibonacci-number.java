class Solution {
    public int fib(int n) {
         /* if(n<=1){
            return n;
            
        }
       int ans= fib(n-1)+fib(n-2);
       return ans; */
 return febo(n);
    }
    int febo( int n){
        if(n<=1)
            return n;

        
        return fib(n-1)+ fib(n-2);
    }
}