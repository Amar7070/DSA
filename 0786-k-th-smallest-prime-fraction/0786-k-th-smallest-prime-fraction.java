class Pair {
    int first;
    int second;
    Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->  Double.compare(((double)b.first / b.second),((double) a.first / a.second)));
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if ((double)arr[i] / arr[j] < 1) {
                    pq.add(new Pair(arr[i], arr[j]));
                    if (pq.size() > k) pq.poll();
                }
            }
        }
        Pair ans = pq.poll();
        return new int[] {ans.first, ans.second};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna