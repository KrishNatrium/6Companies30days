class Solution {
    public Friend createCircularList(int n) {
        if (n <= 0) {
            return null;
        }
        Friend head = new Friend(1);
        Friend current = head;
        for (int i = 2; i <= n; i++) {
            Friend newFriend = new Friend(i);
            current.next = newFriend;
            newFriend.prev = current;
            current = newFriend;
        }
        current.next = head;
        head.prev = current;
        return head;
    }

    public int findTheWinner(int n, int k) {
        if (n == 1)
            return 1;

        Friend curr = createCircularList(n);
        int remaining = n;
        while (remaining > 1) {
            for (int i = 1; i < k; i++) {
                curr = curr.next;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr = curr.next;

            remaining--;
        }
        return curr.k;
    }
}

class Friend {
    Friend prev;
    int k;
    Friend next;

    public Friend(int k) {
        this.k = k;
    }
}