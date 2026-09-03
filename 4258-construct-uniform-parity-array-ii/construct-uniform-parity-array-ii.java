class Solution {
    public boolean uniformArray(int[] nums1) {

        int min = Integer.MAX_VALUE;

        for (int x : nums1) {
            min = Math.min(min, x);
        }

        // Minimum odd => always possible to make all odd
        if (min % 2 == 1) {
            return true;
        }

        // Minimum even
        // If any odd exists, answer is false
        for (int x : nums1) {
            if (x % 2 == 1) {
                return false;
            }
        }

        // All elements are even
        return true;
    }
}