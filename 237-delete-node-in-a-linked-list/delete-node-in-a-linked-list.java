/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // if(node == null){
        //     return null;
        // }
    // node = node.next;
    // return node;
    // if (head == null) {
    //         return null;
    //     }

    //     head = head.next;
    //     return head;
    node.val=node.next.val;
    node.next=node.next.next;
    }
}