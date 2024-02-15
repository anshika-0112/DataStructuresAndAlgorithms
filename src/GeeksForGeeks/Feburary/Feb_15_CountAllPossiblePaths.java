package GeeksForGeeks.Feburary;
/* Level:- Medium (Topic:- Graph)
Problem Statement:- You are presented with an undirected connected graph consisting of n vertices and connections
between them represented by an adjacency matrix. Your objective is to determine whether it is possible to start
traversing from a node, x, and return to it after traversing all the vertices at least once, using each edge exactly once.

Example 1:

Input:
paths = 0 1 1 1 1
        1 0 0 1 0
        1 0 0 1 0
        1 1 1 0 1
        1 0 0 1 0
Output: 1
Explanation:
One can visit the vertices in the following way:
1->3->4->5->1->4->2->1 (assuming 1-based indexing)
Here all the vertices has been visited and all
paths are used exactly once.

Logic Used:- Even Degree Vertex: In a graph, the degree of a vertex is the number of edges incident to it. In this context,
 if a vertex has an even degree, it means that the number of edges connected to that vertex is even.
Necessary Condition: For a graph to have a Eulerian circuit (a circuit that traverses each edge exactly once and returns
 to the starting vertex), it's necessary that every vertex in the graph has an even degree. This is a classic result
 from graph theory.
 */
public class Feb_15_CountAllPossiblePaths {
    public int isPossible(int[][] paths) {
        for (int[] row : paths) {
            if (sumOfArray(row) % 2 != 0) {
                return 0;
            }
        }
        return 1;
    }

    private int sumOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
