/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertPos(Node head, int pos, int val) {
        // code here
        Node temp = new Node(val);
        if (pos == 1) {
            temp.next = head;
            return temp;
        }
        
        Node curr = head;
        for (int i = 1; i < pos - 1; i++) {
            curr = curr.next;
        }
        Node next = curr.next;
        curr.next = temp;
        temp.next = next;
        return head;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna