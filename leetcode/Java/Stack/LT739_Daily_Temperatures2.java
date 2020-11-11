class Solution {  // 3ms 99.30% time O(n) space O(n)
    public int[] dailyTemperatures(int[] T) {
        int[] stack = new int[T.length];
        int[] res = new int[T.length];
        int top = -1;
        
        for (int i = 0; i < T.length; ++i) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                res[idx] = i - idx;
            }
            stack[++top] = i;
        }
        
        return res;
        
    }
}