import java.util.Random;

class Solution {
    private int[][] rects;
    private int[] area;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.random = new Random();
        this.area = new int[rects.length];
        int totalArea = 0;

        // Calculating the cumulative area
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int a = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            totalArea += a;
            area[i] = totalArea;
        }
    }

    public int[] pick() {
        // random number from 1 to total area
        int target = random.nextInt(area[area.length - 1]) + 1;

        // Binary search to find the rectangle
        int low = 0, high = area.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (area[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Get the chosen rectangle
        int[] rect = rects[low];
        int areaStart = low > 0 ? area[low - 1] : 0; // to find where area starts from
        int pointIdx = target - areaStart - 1; // this refers to how much extra area we have covered after the start

        // we find the point using that extra area as an index for the point
        int width = rect[2] - rect[0] + 1;
        int pointX = rect[0] + pointIdx % width;
        int pointY = rect[1] + pointIdx / width;

        return new int[] { pointX, pointY };
    }
}

// /**
// * Your Solution object will be instantiated and called as such:
// * Solution obj = new Solution(rects);
// * int[] param_1 = obj.pick();
// */