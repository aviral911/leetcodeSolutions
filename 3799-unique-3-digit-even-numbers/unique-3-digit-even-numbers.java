import java.util.HashSet;

class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();

        int n = digits.length;

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; // leading zero not allowed

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    if (digits[k] % 2 != 0) continue; // must be even

                    int num = digits[i] * 100 +
                              digits[j] * 10 +
                              digits[k];

                    set.add(num);
                }
            }
        }

        return set.size();
    }
}