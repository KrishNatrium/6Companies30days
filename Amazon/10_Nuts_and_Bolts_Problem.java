package Amazon;

import java.util.HashSet;

class Solution {
    private char[] order = { '!', '#', '$', '%', '&', '*', '?', '@', '^' };

    void matchPairs(int n, char nuts[], char bolts[]) {
        char[] arr = new char[n];
        HashSet<Character> charSet = new HashSet<>();
        for (char nut : nuts) {
            charSet.add(nut);
        }
        int i = 0;
        for (char c : order) {
            if (charSet.contains(c)) {
                arr[i] = c;
                i++;
            }
        }
        System.arraycopy(arr, 0, nuts, 0, n);
        System.arraycopy(arr, 0, bolts, 0, n);

    }
}