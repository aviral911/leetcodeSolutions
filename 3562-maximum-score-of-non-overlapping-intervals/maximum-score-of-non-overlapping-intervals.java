import java.util.*;

class Solution {

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0); // start
            arr[i][1] = intervals.get(i).get(1); // end
            arr[i][2] = intervals.get(i).get(2); // weight
            arr[i][3] = i;                       // original index
        }

        // Sort by start time
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[3], b[3]);
        });

        // Find next non-overlapping interval
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {

            int low = i + 1;
            int high = n;

            while (low < high) {

                int mid = low + (high - low) / 2;

                // Important: start must be STRICTLY greater than end
                if (arr[mid][0] > arr[i][1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            next[i] = low;
        }

        /*
         * dp[i][k]
         *
         * Best answer starting from interval i
         * when we can still choose at most k intervals.
         */
        State[][] dp = new State[n + 1][5];

        // Base case:
        // No intervals left OR no selections allowed
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {

            // If k = 0, we cannot select anything
            dp[i][0] = new State(0, new ArrayList<>());

            for (int k = 1; k <= 4; k++) {

                // OPTION 1: Skip current interval
                State skip = dp[i + 1][k];

                // OPTION 2: Take current interval
                State nextState = dp[next[i]][k - 1];

                List<Integer> takeIndices =
                        new ArrayList<>(nextState.indices);

                takeIndices.add(arr[i][3]);

                Collections.sort(takeIndices);

                State take = new State(
                        arr[i][2] + nextState.score,
                        takeIndices
                );

                dp[i][k] = better(take, skip);
            }
        }

        List<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private State better(State a, State b) {

        // Higher score wins
        if (a.score > b.score) {
            return a;
        }

        if (b.score > a.score) {
            return b;
        }

        // Same score -> lexicographically smaller
        return isLexicographicallySmaller(a.indices, b.indices)
                ? a
                : b;
    }

    private boolean isLexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        // If one is prefix of another,
        // shorter one is lexicographically smaller
        return a.size() < b.size();
    }
}