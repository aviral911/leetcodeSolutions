class Solution {
    public int longestOnes(int[] nums, int k) {
        int max =0;
        for(int i=0;i<nums.length;i++){
            int z=0;
            int j=i;
            for(j=i;j<nums.length;j++){
                if(nums[j]==0)z++;

                if(z>k)break;
            }
            int size= j-i;
            max = Math.max(max,size);
        }
        return max;
    }
}