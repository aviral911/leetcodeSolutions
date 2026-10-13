class Solution {
    public int tribonacci(int n) {
        int  dp[]= new int [n+1];
        return febo(n,dp) ;
}
int febo(int n,int dp[]){
      if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if(dp[n]!=0){
        return dp[n];
    }
return dp[n]=(febo(n-1,dp)+febo(n-2,dp)+febo(n-3,dp));
}
}