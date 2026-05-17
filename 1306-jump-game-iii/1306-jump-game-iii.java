class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int idx = q.poll();
            if(arr[idx] == 0) return true;
            int l = idx - arr[idx];
            int r = idx + arr[idx];
            if(l >= 0 && l < n && !visited[l]) {
                q.add(l);
                visited[l] = true;
            }
            if(r >= 0 && r < n && !visited[r]) {
                q.add(r);
                visited[r] = true;
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna