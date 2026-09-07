class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg=0;
      
      int  sum =0;
         for(int i=0;i<k;i++){
            sum = sum +nums[i];
               
         }
         double max =sum;
         max = Math.max(sum , max);
         for(int i=k;i<nums.length;i++){
            sum = sum +nums[i];
            sum = sum - nums[i-k];
             max = Math.max(sum , max);
         }
         return max/k;
    }
}