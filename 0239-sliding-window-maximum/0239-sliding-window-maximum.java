class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0, r = 0;
        int ans[] = new int[n - k + 1];
        int c = 0;
        while (r < n) {
            while (!q.isEmpty() && q.peekLast() < nums[r]) q.pollLast();
            q.addLast(nums[r]);
            if(r - l + 1 == k) {
                ans[c++] = q.peekFirst();
                if(nums[l] == q.peekFirst()) q.pollFirst();
                l++;
            }
            r++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna