class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = 0;
        for(int num : nums) {
            if(num > l) l = num;
            h += num;
        }
        int ans = 0;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(isPossible(mid, nums, k)) {
                ans = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;

    }
    private boolean isPossible(int max, int[] nums, int k) {
        int s = 1;
        int sum = 0;
        for(int num : nums) {
            if(num + sum > max) {
                s++;
                sum = num;
                if(s > k) return false;
            }
            else sum += num;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna