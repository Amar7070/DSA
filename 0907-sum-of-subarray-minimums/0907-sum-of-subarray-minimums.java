class Solution {
    int mod = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int nse[] = new int[n];
        int pse[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = (!st.isEmpty()) ? st.peek() : n;
            st.push(i);
        }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            pse[i] = (!st.isEmpty()) ? st.peek() : -1;
            st.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            ans = (ans + arr[i] * (left * right % mod)) % mod;
        }
        return (int)ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna