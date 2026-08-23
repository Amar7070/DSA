class Solution {
    static int arr[] = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    public int dayOfYear(String date) {
        String[] str = date.split("-");
        int year = Integer.parseInt(str[0]);
        int month = Integer.parseInt(str[1]);
        int day = Integer.parseInt(str[2]);
        int ans = (month - 2 >= 0) ? arr[month - 2] + day : day;
        if (isLeapYear(year) && month > 2) ans += 1;
        return ans;
    }

    private boolean isLeapYear (int year) {
        if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) return true;
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna