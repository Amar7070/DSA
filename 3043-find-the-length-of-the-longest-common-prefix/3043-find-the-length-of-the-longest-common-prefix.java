class Trie {
    Trie[] child = new Trie[10];
}
class Solution {
    Trie root = new Trie(); 
    private void insert(int n) {
        String s = String.valueOf(n);
        Trie curr = root;
        for(char ch : s.toCharArray()) {
            int idx = ch - '0';
            if(curr.child[idx] == null) {
                curr.child[idx] = new Trie();
            }
            curr = curr.child[idx];
        }
    }
    private int search(int n) {
        String s = String.valueOf(n);
        int c = 0;
        Trie curr = root;
        for(char ch : s.toCharArray()) {
            int idx = ch - '0';
            if(curr.child[idx] == null) {
                break;
            }
            c++;
            curr = curr.child[idx];
        }
        return c;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int arr : arr1) {
            insert(arr);
        }
        int ans = 0;
        for(int arr : arr2) {
            ans = Math.max(ans, search(arr));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna