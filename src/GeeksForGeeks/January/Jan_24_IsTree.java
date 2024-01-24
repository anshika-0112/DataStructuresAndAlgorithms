package GeeksForGeeks.January;

import java.util.*;

/*  Level - Medium (Topic - Tree)
    Problem Statement:- You are given an undirected graph of N nodes (numbered from 0 to N-1) and M edges. Return 1 if the graph is a tree, else return 0.

    Note: The input graph can have self-loops and multiple edges.

    Example 1:

    Input:
    N = 4, M = 3
    G = [[0, 1], [1, 2], [1, 3]]
    Output:
    1
    Explanation:
    Every node is reachable and the graph has no loops, so it is a tree
*/
public class Jan_24_IsTree {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // Create an adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Check for connectedness using DFS
        Set<Integer> visited = new HashSet<>();
        dfs(0, adjList, visited);

        // If the graph is not connected, it's not a tree
        if (visited.size() != n) {
            return false;
        }

        // Check for cycles using DFS
        visited.clear();
        if (hasCycle(-1, 0, adjList, visited)) {
            return false;  // Cycle detected
        }

        // Check if the number of edges is n-1
        return m == n - 1;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adjList, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    private boolean hasCycle(int parent, int node, ArrayList<ArrayList<Integer>> adjList, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                if (hasCycle(node, neighbor, adjList, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;  // Cycle detected
            }
        }
        return false;
    }
}
