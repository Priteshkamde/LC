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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) 
            return null;

        if(head.next == null)
            return head;
            
        if(k == 0)
            return head;

        int lenCount = 1;
        ListNode ptr = head;
        while(ptr.next != null) {
            lenCount++;
            ptr = ptr.next;
        }

        if(k % lenCount == 0)
            return head;

        k = k % lenCount;   
        ptr.next = head; // join the last section
        // at this point the LL is singly-cicular

        int split = lenCount - k;
        int i = 1;
        ListNode ctr = head;
        while(i < split) {
            i++;
            ctr = ctr.next;
        }

        head = ctr.next;
        ctr.next = null;

        return head;

    }
}