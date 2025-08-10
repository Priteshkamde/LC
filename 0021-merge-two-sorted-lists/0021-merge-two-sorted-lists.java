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
        ListNode head = new ListNode();
        ListNode dummy = head;

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                dummy.next = ptr1;
                dummy = dummy.next;
                ptr1 = ptr1.next;
            } else {
                dummy.next = ptr2;
                dummy = dummy.next;
                ptr2 = ptr2.next;
            }
        }

        while (ptr1 != null) {
            dummy.next = ptr1;
            dummy = dummy.next;
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            dummy.next = ptr2;
            dummy = dummy.next;
            ptr2 = ptr2.next;
        }

        return head.next;
    }
}