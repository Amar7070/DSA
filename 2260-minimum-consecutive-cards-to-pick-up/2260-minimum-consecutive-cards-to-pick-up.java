class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(cards[i])) {
                map.put(cards[i], i);
            }
            else {
                ans = Math.min (ans, i - map.get(cards[i]) + 1);
                map.put(cards[i], i);
            }
        }
        return (map.size() == n) ? -1 : ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna