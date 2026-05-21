class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int arr : arr1) {
            String s = String.valueOf(arr);
            String p = "";
            for(char ch : s.toCharArray()) {
                p += ch;
                set.add(p);
            }
        }
        int ans = 0;
        for(int arr : arr2) {
            String s = String.valueOf(arr);
            String p = "";
            for(char ch : s.toCharArray()) {
                p += ch;
                if(set.contains(p)) ans = Math.max(ans, p.length());
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna