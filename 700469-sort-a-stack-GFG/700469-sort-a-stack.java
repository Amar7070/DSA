class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()) return;
        int temp = st.pop();
        sortStack(st);
        insertAtCorrectPlace(st, temp);
    }
    private void insertAtCorrectPlace(Stack<Integer> st, int val) {
        if(st.isEmpty() || st.peek() < val) {
            st.push(val);
            return;
        }
        int top = st.pop();
        insertAtCorrectPlace(st, val);
        st.push(top);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna