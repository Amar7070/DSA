class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;    // tracks the position where next non-zero elememt should be placed  
        for(int i = 0; i < n; i++) {  // traversing array from left to right 
            if(nums[i] != 0) {         // encounter a non-zero element 
                int temp = nums[j];    // swapping it so it pushes all zeroes at the end
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}

// all indices before j contain non-zero elements in their original order

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna