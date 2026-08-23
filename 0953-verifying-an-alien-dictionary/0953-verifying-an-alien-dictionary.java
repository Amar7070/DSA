class Solution {
    HashMap<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char ch = order.charAt(i);
            map.put(ch, i);
        }

        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            if(!checkOrder(words[i], words[i + 1])) return false;
        } 
        return true;
    }

    private boolean checkOrder (String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2) {
                if (map.get(c1) > map.get(c2)) return false;
                else return true;
            }
            i++;
            j++; 
        }
        if (j == s2.length() && i < s1.length()) return false;
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna