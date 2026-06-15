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
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr = head;
        int n = 0;
        while(curr != null) {
            curr = curr.next;
            n++;
        }
        if(n == 1) return null;
        ListNode prev = null;
        curr = head;
        int count = 0;
        while(count < n / 2) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        prev.next = curr.next;
        return head;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna