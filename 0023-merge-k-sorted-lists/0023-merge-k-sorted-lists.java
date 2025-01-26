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

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(ListNode node : lists) {
            ListNode temp = node;
            while(temp != null) {
                pq.add(temp.val);
                temp = temp.next;
            }
        }

        ListNode newList = new ListNode();
        ListNode dummy = newList;

        while(pq.size() > 0) {
            ListNode node = new ListNode(pq.poll());
            dummy.next = node;
            dummy = dummy.next;
        }

        return newList.next;
        
    }
}