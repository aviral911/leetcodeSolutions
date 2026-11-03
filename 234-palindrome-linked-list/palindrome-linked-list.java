/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> l = new ArrayList<>();
        ListNode tmp = head;
        while(tmp!=null){
            l.add(tmp.val);
            tmp = tmp.next;
        }
        int i=0, j=l.size() - 1;
        while(i<j){
            if(l.get(i) != l.get(j))return false;
            i++;
            j--;
        }
        return true;
    }
}