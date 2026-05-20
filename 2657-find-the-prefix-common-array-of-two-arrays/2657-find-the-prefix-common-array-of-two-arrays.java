class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int freq[] = new int[n + 1];
        int ans[] = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            freq[A[i]]++;
            freq[B[i]]--;
            if(A[i] == B[i]) {
                count++;
            }
            else {
                if(freq[A[i]] == 0) count++;
                if(freq[B[i]] == 0) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna