class Solution {
    boolean hasDuplicate (StringBuilder sb, String s2) {
        int freq[] = new int[26];
        
        for (int j = 0; j < sb.length(); j++) {
            freq[sb.charAt(j) - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            if (freq[ch - 'a'] > 0) return true;
            freq[ch - 'a']++;
        }
        return false;
    }

    public int maxLength(List<String> arr) {
        return solve (0, new StringBuilder(), arr);
    }

    private int solve (int i, StringBuilder sb, List<String> arr) {
        if (i == arr.size()) return sb.length();

        int take = 0;
        if (!hasDuplicate(sb, arr.get(i))) {
            int curr = sb.length();
            sb.append(arr.get(i));
            take = solve (i + 1, sb, arr);
            sb.setLength(curr);
        }

        int notTake = solve (i + 1, sb, arr);

        return Math.max (take, notTake);
    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna