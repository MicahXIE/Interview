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
class Solution { // 2ms
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode res = sort(lists, 0, lists.length-1);
        return res;
    }
    
    public ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high) return lists[low];
        
        int mid = (high - low) / 2 + low; 
        ListNode l1 = sort(lists, low, mid); 
        ListNode l2 = sort(lists, mid+1, high);
        
        return mergeTwoLists(l1, l2);
        
    }
    
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