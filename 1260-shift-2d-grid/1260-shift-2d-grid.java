class Solution {
    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    } 

    // 9 1 2 3 4 5 6 7 8;

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int len = n * m;
        int temp[] = new int[len];
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[c++] = grid[i][j];
            }
        }
        k = k % len;

        reverse (temp, 0, len - 1);
        reverse (temp, 0, k - 1);
        reverse (temp, k, len - 1);
        
        List<List<Integer>> ans = new ArrayList<>();
        c = 0;
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                ans.get(i).add(temp[c++]);
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna