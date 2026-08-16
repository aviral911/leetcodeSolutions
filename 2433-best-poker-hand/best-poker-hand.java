class Solution {
    public String bestHand(int[] ranks, char[] suits) {

        // Check Flush
        boolean flush = true;
        for (int i = 1; i < 5; i++) {
            if (suits[i] != suits[0]) {
                flush = false;
                break;
            }
        }

        if (flush) {
            return "Flush";
        }

        // Count rank frequencies
        int[] freq = new int[14]; // ranks are 1 to 13

        for (int rank : ranks) {
            freq[rank]++;
        }

        boolean pair = false;

        for (int count : freq) {
            if (count >= 3) {
                return "Three of a Kind";
            }
            if (count == 2) {
                pair = true;
            }
        }

        return pair ? "Pair" : "High Card";
    }
}