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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1 && head.next == null) return null;
        int d = n+1;
        ListNode first = head;
        while (--d > 0 && first.next != null) {
            first = first.next;
        }
        if (d == 1 && first.next == null) return head.next;
        if (d > 1 && first.next == null) return null;
        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;     
    }
}

/*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode p1 = prev, p2 = prev;

        while(n-- != 0) p1 = p1.next; // ideal case n always valid
        while(p1.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        p2.next = p2.next.next;
        return prev.next;
    }
}
*/