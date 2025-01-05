import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] e) {
        // sort according to accending width, if equal, then decreasing height
        Arrays.sort(e, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // array for LIS
        int[] dp = new int[e.length];
        int dpLen = 0; // LIS length
        // finding where to insert height to make it strictly increasing
        for (int[] arr : e) {
            int h = arr[1];
            int index = Arrays.binarySearch(dp, 0, dpLen, h); // (array, strtIndex, lastIndex, key)
            if (index < 0)
                index = -index - 1; /*
                                     * binarySearch encodes both :
                                     * that the key was not found (negative value).
                                     * Where the key should be inserted (by calculating the insertion point from the
                                     * negative result).
                                     */
            if (index == dpLen)
                dpLen++;
            dp[index] = h;
        }
        return dpLen;
    }
}