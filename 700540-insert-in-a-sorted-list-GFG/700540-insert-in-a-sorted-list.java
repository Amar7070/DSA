/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
        // Add your code here.
        Node temp = new Node(key);
        if (key < head.data) {
            temp.next = head;
            return temp;
        }
        
        Node curr = head;
        while (curr.next != null && key > curr.next.data) {
            curr = curr.next;
        }
        
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna