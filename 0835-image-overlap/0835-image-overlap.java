class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    for (int p = 0; p < n; p++) {
                        for (int q = 0; q < n; q++) {
                            if (img2[p][q] == 1) {
                                int x = p - i;
                                int y = q - j;
                                int curr = x * 100 + y;
                                map.put(curr, map.getOrDefault(curr, 0) + 1);
                                ans = Math.max (ans, map.get(curr));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna