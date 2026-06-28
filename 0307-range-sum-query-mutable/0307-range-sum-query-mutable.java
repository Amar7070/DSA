class NumArray {
    int tree[];
    int arr[];
    private void constructST(int si, int ss, int se) {
        if(ss == se) {
            tree[si] = arr[ss];
            return;
        }
        int mid = (ss + se) / 2;
        constructST(2 * si + 1, ss, mid);
        constructST(2 * si + 2, mid + 1, se);

        tree[si] = tree[2 * si + 1] + tree[2 * si + 2];
    }
    public NumArray(int[] nums) {
        int n = nums.length;
        tree = new int[4 * n];
        arr = nums;
        constructST(0, 0, n - 1);
    }

    private void updateST(int si, int ss, int se, int i, int diff) {
        if(i < ss || i > se) return;
        tree[si] += diff;
        if(ss < se) {
            int mid = (ss + se) / 2;
            updateST(2 * si + 1, ss, mid, i, diff);
            updateST(2 * si + 2, mid + 1, se, i, diff);
        }
    }
    
    public void update(int index, int val) {
        int diff = val -  arr[index];
        arr[index] = val; 
        updateST(0, 0, arr.length - 1, index, diff);
    }

    private int getSum(int qs, int qe, int si, int ss, int se) {
        // No overlap
        if(qs > se || qe < ss) return 0;

        // complete overlap
        if(qs <= ss && qe >= se) return tree[si];

        // partial overlap
        int mid = (ss + se) / 2;
        return getSum(qs, qe, 2 * si + 1, ss, mid) + getSum(qs, qe, 2 * si + 2, mid + 1, se);

    }

    public int sumRange(int left, int right) {
        return getSum(left, right, 0, 0, arr.length - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna