class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k) pq.poll();
        }
        int ans[] = new int[pq.size()];
        int idx = 0;
        while (k-- > 0) {
            ans[idx++] = pq.poll();
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna