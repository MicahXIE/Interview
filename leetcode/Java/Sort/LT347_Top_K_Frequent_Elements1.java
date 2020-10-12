// PriorityQueue
class Solution {   // 11ms 54.91% time O(Nlogk) space O(N + k)
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        Queue<Integer> heap = new PriorityQueue<> (
            (n1, n2) -> map.get(n1) - map.get(n2)
        );

        // keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.poll();
        }
        
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        
        return top;
    }
    
}