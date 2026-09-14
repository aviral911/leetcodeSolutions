class Solution {
    public int search(int[] num, int target) {
        int a =0;
        int b = num.length-1;
        
        while(a<=b){
        int mid = (a+b)/2;
        if(num[mid] == target) return mid;
        
        else if(num[mid]<target)  a = mid+1;
        else{
            b = mid-1;

        }
        
        
        }
    
    return -1;
    }
}