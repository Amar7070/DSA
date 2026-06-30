class Solution {
    int mod = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> nse = new ArrayList<>();
        for (int i = 0; i < n; i++) nse.add(-1);
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if (!st.isEmpty()) nse.set(i, st.peek());
            else nse.set(i, n);
            st.push(i);
        }
        st.clear();
        ArrayList<Integer> pse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            if (!st.isEmpty()) pse.add(st.peek());
            else pse.add(-1);
            st.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse.get(i);
            long right = nse.get(i) - i;
            ans = (ans + arr[i] * (left * right % mod)) % mod;
        }
        return (int)ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna