class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int nse[] = new int[n];
        int pse[] = new int[n];
        int nge[] = new int[n];
        int pge[] = new int[n];

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = (!st.isEmpty()) ? st.peek() : n;
            st.push(i);
        }

        st.clear();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            pse[i] = (!st.isEmpty()) ? st.peek() : -1;
            st.push(i);
        }

        st.clear();

        // Next Greater Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            nge[i] = (!st.isEmpty()) ? st.peek() : n;
            st.push(i);
        }

        st.clear();

        // Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            pge[i] = (!st.isEmpty()) ? st.peek() : -1;
            st.push(i);
        }

        long ans = 0;
        for(int i = 0; i < n; i++) {
            long contInMin = 1L * arr[i] * (nse[i] - i) * (i - pse[i]);
            long contInMax = 1L * arr[i] * (nge[i] - i) * (i - pge[i]);
            ans += (contInMax - contInMin);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna