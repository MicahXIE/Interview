class Solution {  // 24ms 37.71% time O(n) space O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int lo = 0, hi = 0;
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        while (hi < nums.length) {
            if (hi - lo < k) {
                offer(q, nums, hi++);
            } else {
                res[lo] = nums[q.getFirst()];
                if (q.getFirst() == lo++) {
                    q.removeFirst();
                }
            }
        }
        res[lo] = nums[q.getFirst()];
        return res;
    }
    
    // monotonous queue
    private void offer(ArrayDeque<Integer> q, int[] nums, int i) {
        while (!q.isEmpty() && nums[q.getLast()] < nums[i]) {
            q.removeLast();
        }
        q.offer(i);
    }
}