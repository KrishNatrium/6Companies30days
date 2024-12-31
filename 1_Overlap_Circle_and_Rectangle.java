class Solution {
    private int distance(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return (int) Math.sqrt(dx * dx + dy * dy);
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

    }
}