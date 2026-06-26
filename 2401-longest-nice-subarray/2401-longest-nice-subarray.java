class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int m=1;
        for(int i=1;i<n;i++){
            int s=nums[i-1];
            int j=i;
            int count=1;
            while(s+nums[j]==(s^nums[j])){
                s=s+nums[j];
                j++;
                count++;
                if(j>=n) break;
            }
            m=Math.max(m,count);
        }
        return m;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna