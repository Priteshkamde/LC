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
    public ListNode reverseKGroup(ListNode head, int k) {

        // a reverse functio
        // iterate K times for now
        // iteraet until k 
        // once reach NewTempNode.next = K+1 node
        // break the temp.next = null
        // call reverse
        // recive a new temp
        // temp.next = newTempNode.next; // join the links

        ListNode temp = head;
        ListNode prevLast = null;
        while (temp != null) {
            ListNode kthNode = getKthNode(temp, k);

            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverse(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode getKthNode(ListNode head, int k) {
        ListNode dummy = head;
        k-=1;
        while(dummy!= null && k > 0) {
            dummy = dummy.next;
            k-=1;
        }
        return dummy;
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}