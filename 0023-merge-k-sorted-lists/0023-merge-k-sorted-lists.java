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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        // min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> a.val-b.val
        );

        for(ListNode node : lists) {
            if(node != null)
                pq.add(node);
        }

        // heads are present here
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;

        while(!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = curr;
            dummy = dummy.next;

            if(curr!=null && curr.next != null)
                pq.add(curr.next);
        }

        return newHead.next;
    }
}