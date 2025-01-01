class Solution {
    private int avgNeighbours(int[][] img, int r, int c) {
        int sum = 0;
        int avg = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // new row and new column for adding adjacent elements
                int nr = r + i;
                int nc = c + j;
                if (nr >= 0 && nc >= 0 && nr < img.length && nc < img[0].length) {
                    sum += img[nr][nc];
                    avg++; // used the avg for the time being as a counter of number of adjacent elements
                           // added
                }
            }
        }
        avg = sum / avg;
        return avg;
    }

    public int[][] imageSmoother(int[][] img) {
        int[][] simg = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                simg[i][j] = avgNeighbours(img, i, j);
            }
        }
        return simg;
    }
}