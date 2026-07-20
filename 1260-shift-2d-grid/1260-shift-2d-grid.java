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
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        
        while (k-- > 0) {
            int temp[] = new int[n];
            int j = 0;
            for (int i = 0; i < n; i++) {
                reverse(grid[i], 0, m - 1);
                reverse(grid[i], 1, m - 1);
                temp[j++] = grid[i][0];
            }

            reverse(temp, 0, n - 1);
            reverse(temp, 1, n - 1);

            for (int i = 0; i < n; i++) {
                grid[i][0] = temp[i];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                ans.get(i).add(grid[i][j]);
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna