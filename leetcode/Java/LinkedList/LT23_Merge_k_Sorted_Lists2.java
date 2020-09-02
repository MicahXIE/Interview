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
class Solution { // 7ms
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b)->a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }  
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) queue.add(cur.next); // avoid circle [[-2, -1, -1, -1], []]
        }
        
        return dummy.next;
    }
    
}