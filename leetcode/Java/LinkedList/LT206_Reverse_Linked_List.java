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
class Solution {  // 0 ms 100%
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        
        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }
        
        return prev; 
    }
}