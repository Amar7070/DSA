class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) ans.add(-1);
        for (int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if(!st.isEmpty()) ans.set(i, st.peek());
            st.push(arr[i]);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna