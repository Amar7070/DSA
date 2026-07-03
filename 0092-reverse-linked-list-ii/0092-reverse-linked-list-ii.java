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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        int i = 1;
        while (i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode revHead = curr;
        ListNode revTail = null;
        while (i <= right) {
            ListNode next = curr.next;
            curr.next = revTail;
            revTail = curr;
            curr = next;
            i++;
        }
        if(prev != null) prev.next = revTail;
        else head = revTail;
        revHead.next = curr;
        return head;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna