class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int h[] = new int[m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') h[j] = 0;
                else h[j] += 1;
            }
            ans = Math.max(ans, maxInRow(h));
        }
        return ans;
    }
    private int maxInRow(int heights[]) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int nse[] = new int[n];
        int pse[] = new int[n];
        
        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            nse[i] = (!st.isEmpty()) ? st.peek() : n;
            st.push(i);
        }

        st.clear();
        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            pse[i] = (!st.isEmpty()) ? st.peek() : -1;
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n ; i++) {
            int width = nse[i] - pse[i] - 1;
            ans = Math.max(ans, width * heights[i]);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna