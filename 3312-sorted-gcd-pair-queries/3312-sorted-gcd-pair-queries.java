class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;

        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int divisorFreq[] = new int[max + 1];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j * j <= num; j++) {
                if (num % j == 0) {
                    divisorFreq[j]++;
                    if (num / j != j) {
                        divisorFreq[num / j]++;
                    }
                }
            }
        }

        long pairWithGcd[] = new long[max + 1];
        for (int i = max; i >= 1; i--) {
            long count = divisorFreq[i];
            pairWithGcd[i] = count * (count - 1) / 2;

            for (int mul = 2 * i; mul <= max; mul += i) {
                pairWithGcd[i] -= pairWithGcd[mul];
            }
        }

        long prefixCountGcd[] = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefixCountGcd[i] += prefixCountGcd[i - 1] + pairWithGcd[i];
        }

        int q = queries.length;
        int ans[] = new int[q];
        for (int i = 0; i < q; i++) {
            long query = queries[i];
            int l = 1;
            int r = max;
            int temp = 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (prefixCountGcd[mid] > query) {
                    temp = mid;
                    r = mid - 1;
                }
                else l = mid + 1;
            }
            ans[i] = temp;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna