class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int t = 0, b = n - 1;
        int l = 0, r = m - 1;
        while(l < r && t < b) {
            List<Integer> temp = new ArrayList<>();
            for(int i = l; i <= r; i++) {
                temp.add(grid[t][i]);
            }

            for(int i = t + 1; i <= b; i++) {
                temp.add(grid[i][r]);
            }

            for(int i = r - 1; i >= l; i--) {
                temp.add(grid[b][i]);
            }

            for(int i = b - 1; i > t; i--) {
                temp.add(grid[i][l]);
            }
            int rot = k % temp.size();
            rotate(temp, rot);
            int j = 0;
            for(int i = l; i <= r; i++) {
                grid[t][i] = temp.get(j++);
            }

            for(int i = t + 1; i <= b; i++) {
                grid[i][r] = temp.get(j++);
            }

            for(int i = r - 1; i >= l; i--) {
                grid[b][i] = temp.get(j++);
            }

            for(int i = b - 1; i > t; i--) {
                grid[i][l] = temp.get(j++);
            }
            t++;
            l++;
            r--;
            b--;
        }
        return grid;
    }
    private void reverse(List<Integer> list, int s, int e) {
        while(s < e) {
            int temp = list.get(s);
            list.set(s, list.get(e));
            list.set(e, temp);
            s++;
            e--;
        }
    }
    private void rotate(List<Integer> list, int k) {
        int n = list.size();
        reverse(list, 0, n - 1);
        reverse(list, 0, n - k - 1);
        reverse(list, n - k, n - 1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna