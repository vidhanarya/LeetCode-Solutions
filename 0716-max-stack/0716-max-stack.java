class MaxStack {
    int id;
    TreeSet<int[]> stack;
    TreeSet<int[]> values;

    public MaxStack() {
        id = 0;

        Comparator<int[]> comp = (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        };

        stack = new TreeSet<>(comp);
        values = new TreeSet<>(comp);
    }
    
    public void push(int x) {
        stack.add(new int[]{id, x});
        values.add(new int[]{x, id});
        id++;
    }
    
    public int pop() {
        int[] pair = stack.pollLast();
        values.remove(new int[]{pair[1], pair[0]});
        return pair[1];
    }
    
    public int top() {
        int[] pair = stack.last();
        return pair[1];
    }
    
    public int peekMax() {
        int[] pair = values.last();
        return pair[0];
    }
    
    public int popMax() {
        int[] pair = values.pollLast();
        stack.remove(new int[]{pair[1], pair[0]});
        return pair[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */