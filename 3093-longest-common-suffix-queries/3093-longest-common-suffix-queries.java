class Trie {
    Trie[] child = new Trie[26];
    int index = -1;
}
class Solution {
    Trie root;
    boolean best(String words[], int i, int j) {
        if(j == -1) return true;
        else if(words[i].length() < words[j].length()) return true;
        else if(words[i].length() < words[j].length()) return i < j;
        return false;
    }
    void insert(int in, String s, String words[]) {
        Trie curr = root;
        if(best(words, in, curr.index)) {
            curr.index = in;
        }
        for(int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if(curr.child[idx] == null) {
                curr.child[idx] = new Trie();
            }
            curr = curr.child[idx];
            if(best(words, in, curr.index)) {
                curr.index = in;
            }
        }
    }
    int search(String s) {
        Trie curr = root;
        for(int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if(curr.child[idx] == null) {
                break;
            }
            curr = curr.child[idx];
        }
        return curr.index;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        root = new Trie();
        for(int i = 0; i < wordsContainer.length; i++) insert(i, wordsContainer[i], wordsContainer);

        int n = wordsQuery.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna