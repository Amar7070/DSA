# [Minimize Max Distance to Gas Station](https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1)
## Hard
We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1]. Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations, is minimized. We have to find the smallest possible value of d. Find the answer exactly to 6 decimal places.Note:&nbsp;stations is in a strictly increasing order.
Examples:
Input: stations[] = [1, 2, 3, 4, 5], k = 2
Output: 1.00
Explanation: Since all gaps are already equal (1 unit each), adding extra stations in between does not reduce the maximum distance.
Input: stations[] = [3, 6, 12, 19, 33], k = 3Output: 6.00 Explanation: The largest gap is 14 (between 19 and 33). Adding 2 stations there splits it into approx 4.67. The next largest gap is 7 (between 12 and 19). Adding 1 station splits it into 3.5. Now the maximum gap left is 6.
Constraint:1 ≤&nbsp;stations.size() ≤ 1050&nbsp;≤ stations[i]&nbsp;≤ 1060&nbsp;≤ k&nbsp;≤&nbsp;105