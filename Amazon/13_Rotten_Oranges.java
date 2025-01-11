package Amazon;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int min = 0;

        int[][] steps = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty() && fresh > 0) { // for all rotten oranges
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] index = queue.poll(); // index of rotten orange
                for (int[] step : steps) {
                    // its surroundings
                    int row = index[0] + step[0];
                    int col = index[1] + step[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.add(new int[] { row, col });
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if (rotted) {
                min++; // Increment minutes if any fresh orange rotted in this minute
            }
        }

        return fresh == 0 ? min : -1;
    }
}