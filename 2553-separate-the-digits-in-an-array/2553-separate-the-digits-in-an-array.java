class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = n - 1; i >= 0; i--) {
            int temp = nums[i];
            while(temp > 0) {
                int l = temp % 10;
                ans.add(l);
                temp /= 10;
            }
        }
        int res[] = new int[ans.size()];
        int k = 0;
        for(int i = ans.size() - 1; i >= 0; i--) {
            res[k++] = ans.get(i);
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna