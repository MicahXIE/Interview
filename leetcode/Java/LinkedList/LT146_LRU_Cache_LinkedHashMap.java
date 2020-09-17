class LRUCache extends LinkedHashMap<Integer, Integer>{  // 11ms 99.83%
    private int maxSize;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // loadFactor 元素个数与表位置总数之间的最大比例
        this.maxSize = capacity;
    }

    //return -1 if miss
    public int get(int key) {
        Integer v = super.get(key);
        return v == null ? -1 : v;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > maxSize; //must override it if used in a fixed cache
    }
}