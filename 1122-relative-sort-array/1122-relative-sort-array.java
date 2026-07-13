class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans[] = new int[arr1.length];
        int k = 0;
        for (int num : arr2) {
            if (map.containsKey(num)) {
                int freq = map.get(num);
                while (freq-- > 0) {
                    ans[k++] = num;
                }
                map.remove(num);
            }
        }

        ArrayList<Integer> rem = new ArrayList<>();
        for (int key : map.keySet()) {
            int freq = map.get(key);
                while (freq-- > 0) {
                    rem.add(key);
                }
        }
        Collections.sort(rem);
        for (int num : rem) {
            ans[k++] = num;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna