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

        if(lists.length == 0 || lists == null) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
            (a, b) -> (a.val - b.val)
        );

        for(ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }

        ListNode newList = new ListNode();
        ListNode dummy = newList;

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return newList.next;
        
    }
}