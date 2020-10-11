class Solution {    // 0ms 100% time O(n) space O(1)
    public int maxDepth(String s) {
        // Deque<Character> stack = new ArrayDeque<>();
        int length = s.length();
        int max = 0;
        int cur = 0;
        
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == '(') {
                // stack.push(s.charAt(i));
                max = Math.max(max, ++cur);
            } else if (s.charAt(i) == ')') {
                // stack.pop();
                cur--;
            }
        }
        
        return max;
    }
}