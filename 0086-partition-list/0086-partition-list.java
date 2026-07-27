/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode lessEnd = less;
        ListNode greater = new ListNode(0);
        ListNode greaterEnd = greater;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                lessEnd.next = curr;
                lessEnd = curr;
            }
            else {
                greaterEnd.next = curr;
                greaterEnd = curr;
            }
            curr = curr.next;
        }
        lessEnd.next = greater.next;
        greaterEnd.next = null;
        return less.next;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna