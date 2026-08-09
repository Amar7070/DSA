class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int i = n - 1, j = m - 1;
        int matched = 0;
        int rightMatchedLen[] = new int[n];

        while (i >= 0) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                matched++;
                j--;
            }
            rightMatchedLen[i] = matched;
            i--;
        }

        int ans[] = new int[m];
        boolean havePowerChange = true;
        i = 0;
        j = 0;
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }
            else if (havePowerChange && i + 1 < n && rightMatchedLen[i + 1] >= m - j - 1) {
                ans[j] = i;
                j++;
                havePowerChange = false;
            }
            i++;
        }
        if (j == m) return ans;
        return new int[]{};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna