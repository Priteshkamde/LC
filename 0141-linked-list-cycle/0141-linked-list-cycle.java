/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            if(fast.next == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;

    }
}