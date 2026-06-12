class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int s = target-nums[i];
            for(int j=0;j<nums.length;j++){
                if(i!=j && s==nums[j]){
                    a[0]=i;
                    a[1]=j;
                }
            }
        }
        return a;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna