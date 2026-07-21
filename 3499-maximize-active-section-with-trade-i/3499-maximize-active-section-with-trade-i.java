class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        List<Integer> block = new ArrayList<>();
        int oneCount = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                oneCount++;
                if (zero != 0) block.add(zero);
                zero = 0;
            }
            else zero++;
        }

        if (zero != 0) block.add(zero);

        int max = 0;
        for (int i = 0; i < block.size() - 1; i++) {
            max = Math.max(max, block.get(i) + block.get(i + 1));
        }

        return oneCount + max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna