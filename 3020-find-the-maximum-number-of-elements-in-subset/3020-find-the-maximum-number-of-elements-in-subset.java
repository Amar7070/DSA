class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int ans = 0;
        if(map.containsKey(1)) {
            ans = (map.get(1) % 2 == 0) ? map.get(1) - 1 : map.get(1);
            map.remove(1);
        }
        for(int num : nums) {
            int curr = 0;
            int i = num;
            for( ; map.containsKey(i) && map.get(i) > 1; i *= i) {
                curr += 2;
            }
            if (map.containsKey(i)) curr = curr + 1;
            else curr -= 1;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna