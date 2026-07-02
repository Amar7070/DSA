class Pair {
    String s;
    int freq;
    Pair (String s, int freq) {
        this.s = s;
        this.freq = freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) return a.freq - b.freq;
            return (b.s).compareTo(a.s);
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Pair (entry.getKey(), entry.getValue()));
            if (pq.size() > k)
                pq.poll();
            }
        List<String> ans = new ArrayList<>();
        while (k-- > 0) {
            ans.add(pq.poll().s);

        }
        Collections.reverse(ans);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna