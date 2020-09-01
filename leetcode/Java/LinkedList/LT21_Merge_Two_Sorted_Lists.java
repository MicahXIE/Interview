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

// 1ms faster than 42.50%
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode(0);
        ListNode head = tail;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        
        return head.next;
    }
}

/* 0ms faster than 100%
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        
        ListNode head, m1, m2;
        if (l1.val <= l2.val) {
            head = l1;
            m1 = l1;
            m2 = l2;
        } else {
            head = l2;
            m1 = l2;
            m2 = l1;
        }

        while (m1.next != null && m2 != null) {
            if (m1.val <= m2.val && m1.next.val > m2.val) {
                ListNode tmp = m1.next;
                m1.next = m2;
                m2 = m2.next;
                m1.next.next = tmp;
                m1 = m1.next;
            } else {
                m1 = m1.next;
            }
        }
        if (m2 != null) {
            m1.next = m2;
        }
        return head;
    }
}
*/