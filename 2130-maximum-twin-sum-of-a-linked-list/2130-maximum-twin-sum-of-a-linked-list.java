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
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode curr = head;
        int n = 0;
        while(curr!=null) {
            n++;
            curr = curr.next;
        }
        int count = 0;
        ListNode prev = null;
        curr = head;
        while(count < n / 2) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        prev.next = reverse(curr);
        curr = head;
        prev = prev.next;
        int ans = 0;
        while(prev != null) {
            ans = Math.max(prev.val + curr.val, ans);
            prev = prev.next;
            curr = curr.next;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna