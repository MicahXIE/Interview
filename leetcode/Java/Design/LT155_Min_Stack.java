class MinStack {  // 4ms 92.12%

    ArrayList<Integer> st;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        st = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        st.add(x);
        if (x < min)
            min = x;
    }
    
    public void pop() {
        int value = top();
        st.remove(st.size() - 1);
        if (value == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < st.size(); ++i) {
                if (st.get(i) < min)
                    min =st.get(i);
            }
        }
    }
    
    public int top() {
        return st.get(st.size() - 1);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */