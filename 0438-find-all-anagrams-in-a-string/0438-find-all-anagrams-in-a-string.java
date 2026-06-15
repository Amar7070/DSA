class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int freq[] = new int[26];
        for(char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }
        int l = 0, r = 0;
        int count = p.length();
        int k = count;
        while(r < n) {
            int rc = s.charAt(r);
            if(freq[rc - 'a'] > 0) {    // character enters the window
                count--;
            }
            freq[rc - 'a']--;

            if(r - l + 1 == k) {
                if(count == 0) ans.add(l);
                int lc = s.charAt(l);
                freq[lc - 'a']++;
                if(freq[lc - 'a'] > 0) {
                    count ++;
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