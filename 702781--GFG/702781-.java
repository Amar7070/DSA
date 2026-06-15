// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int freq[] = new int[26];
        for(char ch : pat.toCharArray()) {
            freq[ch - 'a']++;
        }
        int l = 0;
        int r = 0;
        int count = pat.length();
        int ans = 0;
        while(r < txt.length()) {
            char right = txt.charAt(r);
            if(freq[right - 'a'] > 0) {
                count--;
            }
            freq[right - 'a']--;
            if(r - l + 1 == pat.length()) {
                if(count == 0) ans++;
                char left = txt.charAt(l);
                freq[left - 'a']++;
                if(freq[left - 'a'] > 0) {
                    count++;
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna