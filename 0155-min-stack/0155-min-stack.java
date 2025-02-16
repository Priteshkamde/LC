class MinStack {

    Deque<int[]> dq;

    public MinStack() {
        dq = new ArrayDeque<int[]>();
    }
    
    public void push(int val) {
        int min = val;
        if(!dq.isEmpty())
            min = Math.min(min, dq.peek()[1]);
        dq.addFirst(new int[]{val, min});
    }
    
    public void pop() {
        if(!dq.isEmpty())
            dq.pollFirst();
    }
    
    public int top() {
        return dq.peek()[0];
    }
    
    public int getMin() {
        return dq.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */