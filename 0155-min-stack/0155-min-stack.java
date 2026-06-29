// Review: This MinStack implementation correctly supports push, pop, top, and getMin in O(1) time.
// Time Complexity: O(1) for each operation (push, pop, top, getMin).
// Space Complexity: O(n) where n is the number of elements, due to storing elements in both stack and minStack.
// The logic correctly handles duplicate minimum values by pushing them onto minStack whenever they appear.
// Minor style suggestion: the push method's condition can be simplified to:
//   if (minStack.isEmpty() || value <= minStack.peek()) minStack.push(value);
// However, the current implementation works correctly and meets the problem constraints.
// Ready to submit.

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int value) {
        // If minStack is empty or the new value is <= current min, push onto minStack.
        // This ensures minStack always holds the current minimum(s).
        if(minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
        stack.push(value);
    }
    
    public void pop() {
        // If the element being popped is the current minimum, also pop from minStack.
        if(minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        // Returns the top element of the main stack.
        return stack.peek();
    }
    
    public int getMin() {
        // Returns the current minimum element in O(1) time.
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna