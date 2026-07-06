class Pair {
    double maxSec;
    int idx;
    Pair (double maxSec, int idx) {
        this.maxSec = maxSec;
        this.idx = idx;
    }
}
class Solution {
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        if (n == 1) return 0;
        int howMany[] = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.maxSec, a.maxSec));
        
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(stations[i + 1] - stations[i], i));
        }
        for (int gasStations = 1; gasStations <= K; gasStations++) {
            int idx = pq.poll().idx;
            howMany[idx]++;
            double initialDiff = stations[idx + 1] - stations[idx];
            double newSecLen = initialDiff / (double)(howMany[idx] + 1);
            pq.add(new Pair (newSecLen, idx));
        }
        
        return pq.poll().maxSec;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna