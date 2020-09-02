class Solution {  // 2ms 80%
    public int longestValidParentheses(String s) {
        if(s == null && s.length() == 0) return 0;
        
        int begin = 0, max = 0;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (st.isEmpty()) 
                    begin = i + 1;
                else {
                    st.pop();
                    if (st.isEmpty()) 
                        max = Math.max(max, i-begin+1);
                    else
                        max = Math.max(max, i-(st.peek()+1)+1);
                }
            }
        }
        return max;   
    }
}