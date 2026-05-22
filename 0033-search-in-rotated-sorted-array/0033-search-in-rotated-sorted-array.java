class Solution {
    public int binarySearch(int[] a,int l,int h,int t){
        while(l<=h){
            int m=l+(h-l)/2;
            if(a[m]==t) return m;
            else if(a[m]<t) l=m+1;
            else h=m-1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        int e=h;
        while(l<h){
            int m=l+(h-l)/2;
            if(nums[m]>nums[h]){
                l=m+1;
            }
            else{
                h=m;
            }
        }
        if(nums[l]==target) return l;
        if(target>nums[e] && l-1>=0){
            return binarySearch(nums,0,l-1,target);
        }
        else{
            return binarySearch(nums,l,e,target);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna