class Solution {
    public long countCommas(long n) {
        long ans = 0;

        long start = 1000; // 10^3
        long next = 1000000; // 10^6

        for (int k = 1; start <= n; k++) {
            long end = Math.min(n, next - 1);

            ans += (end - start + 1) * k;

            start = next;

            if (next > Long.MAX_VALUE / 1000) break;
            next *= 1000;
        }

        return ans;
    }
}