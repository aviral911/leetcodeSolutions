class Solution {
    public int longestSubarray(int[] nums) {
        int s = 0;
        int e = 0;
        int max = 0;
        int z = 0;
        while (e < nums.length) {
            int num = nums[e];
            if (num == 0)
                z++;
            while (z > 1) {
                int se = nums[s];
                if (se == 0)
                    z--;

                s++;

            }
            int size = e - s + 1;
            max = Math.max(max, size - 1);
            e++;

        }
        return max;

    }
}