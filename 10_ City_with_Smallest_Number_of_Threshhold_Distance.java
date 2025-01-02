class Solution {
    private final int INF = Integer.MAX_VALUE;
    int[][] graph;

    public int findTheCity(int n, int[][] edges, int dt) {
        int ans = 0;
        graph = new int[n][n];

        // making an weighted adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = INF;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        // call floyd warshal to get the distance to all the nodes form all the nodes
        floydWarshall();

        int[] tdc = new int[n]; // tdc mean threshold distance city, it keeps track of how many cities are in
                                // threshold distance
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } else if (graph[i][j] <= dt) {
                    tdc[i]++;
                }
            }
        }

        int min = INF;
        for (int i = 0; i < n; i++) {
            if (tdc[i] < min || (tdc[i] == min && i > ans)) {
                min = tdc[i];
                ans = i;
            }

        }
        return ans;
    }

    private void floydWarshall() {
        int V = graph.length;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}