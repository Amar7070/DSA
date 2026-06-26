class BrowserHistory {
    Stack<String> curr;
    Stack<String> next;
    public BrowserHistory(String homepage) {
        curr = new Stack<>();
        curr.push(homepage);
        next = new Stack<>();
    }
    
    public void visit(String url) {
        curr.push(url);
        next.clear();
    }
    
    public String back(int steps) {
        while(steps-- > 0) {
            if(curr.size() == 1) break;
            next.push(curr.pop());
        }
        return curr.peek();
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && !next.isEmpty()) {
            curr.push(next.pop());
        }
        return curr.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna