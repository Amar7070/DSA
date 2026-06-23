class Solution {
    public boolean binarySearch(int[] arr, int k) {
        // code here
        int l = 0;
        int r = arr.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(arr[m] == k) return true;
            else if(arr[m] < k) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna