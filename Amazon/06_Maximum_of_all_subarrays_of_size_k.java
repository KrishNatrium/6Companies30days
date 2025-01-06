package Amazon;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>(); // answer list
        Deque<Integer> d = new LinkedList<>(); // for the indices

        // getting the deque and list ready with the first window
        for (int i = 0; i < k; i++) {
            while (!d.isEmpty() && arr[i] >= arr[d.peekLast()]) {
                d.pollLast();
            }
            d.offerLast(i);
        }
        list.add(arr[d.peekFirst()]);

        for (int i = k; i < n; i++) {
            // removing smaller indices that are out of window
            while (!d.isEmpty() && d.peekFirst() < i - k + 1) {
                d.pollFirst();
            }

            // removing smaller elements than newer element added to window
            while (!d.isEmpty() && arr[i] >= arr[d.peekLast()]) {
                d.pollLast();
            }
            d.offerLast(i);
            list.add(arr[d.peekFirst()]);
        }

        return list;
    }
}