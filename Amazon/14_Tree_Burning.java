package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

   TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
   this.left = left;
   this.right = right;
   }
}
class Solution {
    private Map<Integer, List<Integer>> treeToGraph(TreeNode root) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(root, graph);
        return graph;
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null)
            return;
        graph.putIfAbsent(root.val, new ArrayList<Integer>());

        if (root.left != null) {
            graph.get(root.val).add(root.left.val); // add the child node to the list
            graph.putIfAbsent(root.left.val, new ArrayList<Integer>()); // make list for node if not exists already
            graph.get(root.left.val).add(root.val); // add the parent node
            dfs(root.left, graph); // recurse
        }
        if (root.right != null) {
            graph.get(root.val).add(root.right.val); // add the child node to the list
            graph.putIfAbsent(root.right.val, new ArrayList<Integer>()); // make list for node if not exists already
            graph.get(root.right.val).add(root.val); // add the parent node
            dfs(root.right, graph); // recurse
        }
    }

    public int maxDistance(Map<Integer, List<Integer>> graph, int start) {
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        // Map to store the distance of each node from the start node
        Map<Integer, Integer> distances = new HashMap<>();
        // Initialize the distance of the start node as 0
        distances.put(start, 0);
        queue.offer(start);

        int maxDistance = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // Get the current distance of the node
            int currentDistance = distances.get(node);

            // Explore all the neighbors of the current node
            for (int neighbor : graph.get(node)) {
                // If the neighbor has not been visited yet
                if (!distances.containsKey(neighbor)) {
                    // Set its distance as the current node's distance + 1
                    distances.put(neighbor, currentDistance + 1);
                    // Add the neighbor to the queue for further exploration
                    queue.offer(neighbor);
                    // Update the max distance if necessary
                    maxDistance = Math.max(maxDistance, currentDistance + 1);
                }
            }
        }

        return maxDistance;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = treeToGraph(root);
        return maxDistance(graph, start);
    }
}