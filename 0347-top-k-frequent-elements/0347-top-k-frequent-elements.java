class Pair {
    int num;
    int freq;
    Pair (int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair (entry.getKey(), entry.getValue()));
            if (pq.size() > k) pq.poll();
        }
        int ans[] = new int[pq.size()];
        int idx = 0;
        while (k-- > 0) {
            ans[idx++] = pq.poll().num;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna