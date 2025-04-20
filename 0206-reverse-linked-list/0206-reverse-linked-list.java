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
    public ListNode reverseList(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;
        // 1-> 2 -> 3 -> null
        // preserve 1->2
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev; // reverse
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}