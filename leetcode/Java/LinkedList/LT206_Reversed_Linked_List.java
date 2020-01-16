/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode n1 = head;
        ListNode n2 = head.next;
        
        n1.next = null;
        while(null != n2) {
            ListNode tmp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = tmp;
        }
        
        return n1;
        
    }
}

