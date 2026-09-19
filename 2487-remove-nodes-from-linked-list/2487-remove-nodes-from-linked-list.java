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
    private ListNode reverse (ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode revHead = reverse (head);
        int max = revHead.val;
        ListNode curr = revHead.next;
        ListNode prev = revHead;

        while (curr != null) {
            if (curr.val >= max) {
                max = curr.val;
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null;

        ListNode newHead = reverse (revHead);
        return newHead; 
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna