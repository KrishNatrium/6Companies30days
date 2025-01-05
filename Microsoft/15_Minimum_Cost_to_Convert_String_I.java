class Solution {
    private final long INF = Long.MAX_VALUE >> 1;
    long[][] graph;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26; // max size of graph
        long ans = 0L;
        graph = new long[n][n];
        // making an weighted adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    graph[i][j] = 0L;
                else
                    graph[i][j] = INF;
            }
        }
        for (int i = 0; i < original.length; i++) {
            int index1 = original[i] - 'a';
            int index2 = changed[i] - 'a';
            graph[index1][index2] = Math.min(graph[index1][index2], (long) cost[i]);

        }
        // using floyd warshall to get the minimum cost from every alphabet to every
        // alphabet
        floydWarshall();

        for (int i = 0; i < source.length(); i++) {
            int j = source.charAt(i) - 'a';
            int k = target.charAt(i) - 'a';
            if (graph[j][k] == INF) {
                return -1;
            }
            ans += graph[j][k];
        }

        return ans;
    }

    private void floydWarshall() {
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (graph[i][k] != INF) {
                    for (int j = 0; j < 26; j++) {
                        if (graph[k][j] != INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
    }
}