class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String ch : tokens) {
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                if(ch.equals("+")) st.push(a + b);
                else if(ch.equals("-")) st.push(a - b);
                else if(ch.equals("*")) st.push(a * b);
                else st.push(a / b);
            }
            else st.push(Integer.parseInt(ch));
        }
        return st.peek();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna