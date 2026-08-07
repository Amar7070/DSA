# [Insertion at the beginning of Circular Linked List](https://www.geeksforgeeks.org/problems/insertion-at-the-beginning-of-circular-linked-list/1)
## Medium
You are given a&nbsp;Circular&nbsp;Linked List and an integer&nbsp;key&nbsp;representing a node. Insert the given key node at the beginning of the circular linked list.Note that the function will receive the tail pointer of the Circular Linked List.Note:

You don't have to print anything, just return the head of the modified list in each function.
Nodes may consist of Duplicate values.

Examples:
Input: key = 5,    Output: 5 -&gt; 1 -&gt; 7 -&gt; 8 -&gt; 10Explanation: After inserting 5 at the beginning of the given circular linked list, it has elements as 5, 1, 7, 8, 10. &nbsp; 
Input: key = 1,   Output: 1 -&gt; 2 -&gt; 5 -&gt; 7 -&gt; 8 -&gt; 10
Explanation: After inserting 1 at the beginning of the given circular linked list, it has elements as 1, 2, 5, 7, 8, 10.   
Constraints:1 ≤&nbsp;number of nodes&nbsp;≤&nbsp;1050 ≤&nbsp;node -&gt; data, key ≤ 105