class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int count[] = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }
        int idx = 0;
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[idx++] = num;
                count[num]--;
            }
        }

        for (int i = 0; i <= 1000; i++) {
            while (count[i] > 0) {
                arr1[idx++] = i;
                count[i]--;
            }
        }
        return arr1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna