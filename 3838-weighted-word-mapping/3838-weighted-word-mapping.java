class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char c[] = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            int s = 0;
            for(char ch : word.toCharArray()) {
                s += weights[ch - 'a']; 
            }
            int idx = (s % 26);
            sb.append(c[idx]); 
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna