class Solution {
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {
        // code here
        int n = arr.length;
        int diff[] = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int op[] : opr) {
            int l = op[0];
            int r = op[1];
            int val = op[2];
            diff[l] += val;
            if(r + 1 < n) diff[r + 1] -= val;
        }
        for(int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        for(int i = 0; i < n; i++) {
            ans.add(arr[i] += diff[i]);
        }
        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna