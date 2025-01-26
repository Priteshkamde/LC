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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode preLeft = dummy;
        ListNode curr = head;

        for(int i = 0 ; i < left-1 ; i++) {
            preLeft = preLeft.next;
            curr = curr.next;
        }

        ListNode subHead = curr;
        ListNode preNode = null;
        for(int i=0; i<= right - left; i++){
            ListNode nextNode = curr.next;
            curr.next = preNode;
            preNode = curr;
            curr = nextNode;
        }

        preLeft.next = preNode;
        subHead.next = curr;

        return dummy.next;

    }
}