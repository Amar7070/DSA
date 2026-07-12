class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 1;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], r);
                r++;
            }
        }
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna