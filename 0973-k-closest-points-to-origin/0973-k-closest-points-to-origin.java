class Pair {
    int x;
    int y;
    long d;
    Pair (int x, int y, long d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> (int)(b.d - a.d));
        for(int p[] : points) {
            long dist = (p[0] * p[0]) + (p[1] * p[1]);
            pq.add(new Pair(p[0], p[1], dist));
            if(pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (k-- > 0) {
            Pair curr = pq.poll();
            ans[i][0] = curr.x;
            ans[i][1] = curr.y;
            i++;
        }
        return ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna