class Solution {  // 12ms 90.15% time O(n) space O(n)
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[T.length];
        
        for (int i = 0; i < T.length; ++i) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        
        return res;
        
    }
}