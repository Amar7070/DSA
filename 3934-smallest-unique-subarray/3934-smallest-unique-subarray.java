class Solution {
    long mod = 1000000007;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int max = 0;
        for (int num : nums) max = Math.max (num, max);
        long base = 1L + max;

        int l = 1;
        int r = n;
        int ans = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check (nums, mid, base)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    private boolean check (int nums[], int mid, long base) {
        int n = nums.length;

        long hash = 0;
        Map<Long, Integer> map = new HashMap<>();

        long p = pow (base % mod, mid - 1);

        int i = 0, j = 0;

        while (j < n) {
            hash = (hash * base + nums[j]) % mod;

            if (j - i + 1 < mid) j++;
            else {
                map.put (hash, map.getOrDefault(hash, 0) + 1);

                hash = (hash - (p * nums[i]) % mod + mod) % mod;
                i++;
                j++;
            }
        }

        for (int count : map.values()) {
            if (count == 1) return true;
        }

        return false;
    } 

    private long pow (long a, long e) {
        if (e == 0) return 1;

        long half = pow (a, e / 2);
        long ans = (half * half) % mod;

        if (e % 2 == 1) {
            ans = (ans * a) % mod;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna