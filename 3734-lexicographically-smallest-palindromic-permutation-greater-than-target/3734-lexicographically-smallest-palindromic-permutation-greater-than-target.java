class Solution {
    int half;
    String ans = "";
    char midChar = 'A';

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int freq[] = new int[26];

        for (char ch : s.toCharArray()) freq[ch - 'a']++;

        int halfFreq[] = new int[26];

        int oddFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1){
                midChar = (char)(i + 'a');
                oddFreq++;
            }
            halfFreq[i] = freq[i] / 2;
        }

        if (oddFreq > 1) return "";

        half = n / 2;

        solve (0, new StringBuilder(), halfFreq, target, false);

        return ans;
    }

    private boolean solve (int i, StringBuilder sb, int freq[], String target, boolean greater) {
        if (i == half) {
            
            String left = sb.toString();
            String right = new StringBuilder(sb).reverse().toString();

            String curr;

            if (midChar != 'A') curr = left + midChar + right;
            else curr = left + right;

            if (curr.compareTo(target) > 0) {
                ans = curr;
                return true;
            }

            return false;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (freq[ch - 'a'] == 0) continue;

            if (!greater && ch < target.charAt(i)) continue;

            sb.append(ch);
            freq[ch - 'a']--;

            boolean isGreater = greater || ch > target.charAt(i);

            if (solve (i + 1, sb, freq, target, isGreater)) return true;

            sb.deleteCharAt(sb.length() - 1);

            freq[ch - 'a']++;
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna