class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        // int n = arr.length;
        // int l = 0;
        // int h = n;
        // while (l < h) {
        //     int mid = l + (h - l) / 2;
        //     if (arr[mid] < target) l = mid + 1;
        //     else h = mid;
        // }
        // return l;
        int n = arr.length;
        int l = 0;
        int h = n - 1;
        int ans = n;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna