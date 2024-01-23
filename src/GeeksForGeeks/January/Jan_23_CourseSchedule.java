package GeeksForGeeks.January;

import java.util.*;

/*  Level - Medium (Topic - Topological Sort)
Problem Statement - There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have
prerequisite tasks, for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering of tasks you should pick
to finish all tasks.

    Example 1:

    Input:
    n = 2, m = 1
    prerequisites = {{1, 0}}
    Output:
    1
    Explanation:
    The output 1 denotes that the order is valid. So, if you have, implemented your function correctly,
     then output would be 1 for all test cases. One possible order is [0, 1].
*/
public class Jan_23_CourseSchedule {
    static int[] findOrder(int numCourses, int prerequisitesCount, ArrayList<ArrayList<Integer>> prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build the adjacency list and calculate indegrees
        for (ArrayList<Integer> prerequisite : prerequisites) {
            int pre = prerequisite.get(0);
            int course = prerequisite.get(1);
            adjacencyList.get(course).add(pre);
            indegree[pre]++;
        }

        // Initialize the queue with nodes having an indegree of 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // Process nodes in topological order using BFS
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            result[index++] = currentCourse;

            for (int prerequisite : adjacencyList.get(currentCourse)) {
                indegree[prerequisite]--;
                if (indegree[prerequisite] == 0) {
                    queue.add(prerequisite);
                }
            }
        }

        // Check if all courses are taken, otherwise, return an empty array
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}

