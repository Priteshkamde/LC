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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> (a.val - b.val)
        );

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode head = new ListNode();
        ListNode dummy = head;

        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val < ptr2.val) {
                dummy.next = ptr1;
                dummy = dummy.next;
                ptr1 = ptr1.next;
            } else {
                dummy.next = ptr2;
                dummy = dummy.next;
                ptr2 = ptr2.next;
            }
        }

        while(ptr1!= null) {
            dummy.next = ptr1;
            dummy = dummy.next;
            ptr1 = ptr1.next;
        }
        while(ptr2!= null) {
            dummy.next = ptr2;
            dummy = dummy.next;
            ptr2 = ptr2.next;
        }

        return head.next;
    }
}