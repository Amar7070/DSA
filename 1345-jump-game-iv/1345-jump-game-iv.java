class Pair {
    int i;
    int count;
    Pair(int i, int count) {
        this.i = i;
        this.count = count;
    }
}
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                if(i > 0 && i + 1 < n && arr[i - 1] == arr[i] && arr[i] == arr[i + 1]) continue;
                map.get(arr[i]).add(i);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(arr[i], temp);
            }
        }
        Queue<Pair> q = new ArrayDeque<>();
        boolean visited[] = new boolean[n];
        q.add(new Pair(0, 0));
        visited[0] = true;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int idx = p.i;
            int count = p.count;
            if(idx == n - 1) return count;
            if(idx - 1 >= 0 && !visited[idx - 1]) {
                q.add(new Pair(idx - 1, count + 1));
                visited[idx - 1] = true;
            }
            if(idx + 1 < n && !visited[idx + 1]) {
                q.add(new Pair(idx + 1, count + 1));
                visited[idx + 1] = true;
            }
            if(map.containsKey(arr[idx])) {
                for(int i : map.get(arr[idx])) {
                    if(i != idx && !visited[i]) {
                        q.add(new Pair(i, count + 1));
                        visited[i] = true;
                    }
                }
                map.remove(arr[idx]);
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna