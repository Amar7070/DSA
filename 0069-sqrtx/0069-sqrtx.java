class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int l = 0;
        int h = x / 2;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            long sqrt = (long)mid * mid;
            if(sqrt == x) return mid;
            else if(sqrt > x) h = mid - 1;
            else l = mid + 1;
        } 
        return h;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna