/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        
        boolean flagA = true; // list A is first time to reach end;
        boolean flagB = true; // list B is first time to reach end;
        while (tmpA != null && tmpB != null) {
            if (tmpA == tmpB)
                return tmpA;
            tmpA = tmpA.next;
            tmpB = tmpB.next;
            if (tmpA == null && flagA) {
                tmpA = headB;
                flagA = false;
            }
            if (tmpB == null && flagB) {
                tmpB = headA;
                flagB = false;
            }
        }
        return null;  
    }
}