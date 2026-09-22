class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int sum = 0;
        int temp[] = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            temp[i] = (i < n) ? code[i] : code[i - n];
        }
        int[] ans = new int[n];
        if (k == 0)
            return ans;
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                sum += temp[i];
            }
            for (int i = 0; i < n; i++) {
                sum += temp[i + k] - temp[i];
                ans[i] = sum;
            }
        } else {
            k = k * (-1);
            for (int i = temp.length - 1; i > temp.length - k - 1; i--) {
                sum += temp[i];
            }
            for (int i = n - 1; i >= 0; i--) {
                sum += temp[n + i - k] - temp[n + i];
                ans[i] = sum;
            }
        }
        return ans;
    }
}