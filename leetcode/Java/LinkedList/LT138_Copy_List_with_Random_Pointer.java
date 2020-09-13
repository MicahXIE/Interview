/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node dummy = new Node(0);
        Node tmp = head; 
        Node tmp1 = dummy; 
        while (tmp != null) {
            Node nd = new Node(tmp.val);
            map.put(tmp, nd);
            tmp1.next = nd;
            tmp1 = tmp1.next;
            tmp = tmp.next;
        }
        tmp1 = dummy.next; // new head
        tmp = head; // old head
        while (tmp != null && tmp1 != null) {
            Node rdm = map.get(tmp.random);
            tmp1.random = rdm;
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }
        
        return dummy.next;
        
    }
}