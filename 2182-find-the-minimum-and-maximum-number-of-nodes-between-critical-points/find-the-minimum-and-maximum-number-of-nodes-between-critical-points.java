class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prevCritical = -1;
        int minDist = Integer.MAX_VALUE;

        int pos = 2;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {

            boolean isMax =
                    curr.val > prev.val &&
                    curr.val > curr.next.val;

            boolean isMin =
                    curr.val < prev.val &&
                    curr.val < curr.next.val;

            if (isMax || isMin) {

                if (first == -1) {
                    first = pos;
                } else {
                    minDist = Math.min(
                            minDist,
                            pos - prevCritical
                    );
                }

                prevCritical = pos;
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        int maxDist = prevCritical - first;

        return new int[]{minDist, maxDist};
    }
}