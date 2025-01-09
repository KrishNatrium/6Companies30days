package Amazon;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Solution {
    static void linkdelete(Node head, int n, int m) {
        Node curr = head;

        while (curr != null) {
            // Skip m nodes
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }

            // If we reached the end of the list, break
            if (curr == null) {
                break;
            }

            // Start deleting the next n nodes
            Node temp = curr.next;
            for (int i = 1; i <= n && temp != null; i++) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
    }
}