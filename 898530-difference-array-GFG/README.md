# [Difference Array](https://www.geeksforgeeks.org/problems/difference-array/1)
## Medium
You are given an array arr[] and a&nbsp; 2D array opr[][], where each opr[i] denotes an operation in the format [l, r, v].For each operation [l, r, v],&nbsp;you need to add the value v to all elements of the array from index l to&nbsp;r (both inclusive).
Apply all operations sequentially in the given order, and return the final updated array.
Examples:
Input: arr[] = [2, 3, 5, 6, 7], opr[][] = [[2, 4, 2], [3, 4, -1]]Output: [2, 3, 7, 7, 8]Explaination:Operation [2, 4, 2] : Add 2 to indices 2 to 4 → [2, 3, 7, 8, 9] Operation [3, 4, -1] : Substract 1 from indices 3 to 4 → [2, 3, 7, 7, 8] Final array is [2, 3, 7, 7, 8].
Input: arr[] = [4, 5, 7, 9], opr[][] = [[1, 3, 1], [2, 3, -2]]Output: [4, 6, 6, 8]Explaination:Operation [1, 3, 1] : Add 1 to indices 1 to 3 → [4, 6, 8, 10] Operation [2, 3, -2] : Substract 2 from indices 2 to 3 → [4, 6, 6, 8] Final array is [4, 6, 6, 8].
Constraints:1 ≤ arr.size() ≤ 1051 ≤ arr[i] ≤ 1031 ≤ opr.size() ≤ 1050 ≤ l ≤ r &lt; arr.size()-103 ≤ v ≤&nbsp;103