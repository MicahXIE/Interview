class LRUCache { // 21ms 36.50%
    private class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.value = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        
        ListNode current = map.get(key);
        deleteNode(current);
        moveToHead(current);
        
        return current.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        
        ListNode newHead = new ListNode(key, value);
        moveToHead(newHead);
        map.put(key, newHead);
    }
    
    public void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    
    public void moveToHead(ListNode node) {
        ListNode tmp = head.next;
        head.next = node;
        node.prev = head;
        node.next = tmp;
        tmp.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */