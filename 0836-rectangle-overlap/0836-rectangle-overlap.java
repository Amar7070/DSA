class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1_x1 = rec1[0];
        int rec1_y1 = rec1[1];
        int rec1_x2 = rec1[2];
        int rec1_y2 = rec1[3];

        int rec2_x1 = rec2[0];
        int rec2_y1 = rec2[1];
        int rec2_x2 = rec2[2];
        int rec2_y2 = rec2[3];

        if (rec1_x2 <= rec2_x1 || rec1_x1 >= rec2_x2 || rec1_y2 <= rec2_y1 || rec1_y1 >= rec2_y2) return false;

        return true;


    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna