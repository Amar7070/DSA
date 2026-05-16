class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int m=l + (h - l)/2;
            if(nums[m]>nums[h]){
                l=m+1;
            }
            else if(nums[m]<nums[h]){
                h=m;
            }
            else{
                h--;
            }
        }
        return nums[(l)%nums.length];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna