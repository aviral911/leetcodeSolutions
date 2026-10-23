class Solution {
    public int addDigits(int num) {
        int n = num;
    if(n<10){
        return num;
    }              
       return 1+(num-1)%9;
                 
    }
}