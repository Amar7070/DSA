class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        for(int num : nums) {
            max = Math.max(num, max);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if(max + 1 != n || map.get(max) != 2) return false;
        for(int i = 1; i < max; i++) {
            if(!map.containsKey(i) || map.get(i) != 1) return false;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna