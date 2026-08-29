class Pair {
    int idx;
    int num;
    Pair (int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}

class DSU {
    int parent[];
    int rank[];

    DSU (int n, int nums[]) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find (int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union (int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        }
        else if (rank[px] > rank[py]) {
            parent[py] = px;
        }
        else {
            parent[px] = py;
            rank[py]++;
        }
    }
}
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair (i, nums[i]);
        }

        DSU dsu = new DSU (n, nums);

        Arrays.sort (arr, (a, b) -> a.num - b.num);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1].num - arr[i].num <= limit) {
                dsu.union(arr[i].idx, arr[i + 1].idx);
            }
        }

        List<Integer>[] gp = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            int p = dsu.find(i);
            if (gp[p] == null) {
                gp[p] = new ArrayList<>();
            }
            gp[p].add(i);
        }

        int ans[] = new int[n];
        int nextIdx[] = new int[n];

        for (int i = 0; i < n; i++) {
            int o = arr[i].idx;
            int p = dsu.find(o);
            int t = gp[p].get(nextIdx[p]);
            ans[t] = arr[i].num;
            nextIdx[p]++;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna