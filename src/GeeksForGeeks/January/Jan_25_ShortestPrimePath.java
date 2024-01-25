package GeeksForGeeks.January;

import java.util.*;

/* Level - Hard (Topic - BFS)
    Problem Statement:- You are given two four digit prime numbers num1 and num2. Find the distance of the shortest path
    from Num1 to Num2 that can be attained by altering only single digit at a time such that every number that we get
    after changing a digit is a four digit prime number with no leading zeros.

    Example 1:

    Input:
    num1 = 1033
    num2 = 8179
    Output: 6
    Explanation:
    1033 -> 1733 -> 3733 -> 3739 -> 3779 -> 8779 -> 8179.
    There are only 6 steps required to reach num2 from num1.
    and all the intermediate numbers are 4 digit prime numbers.
 */

public class Jan_25_ShortestPrimePath {
    public int solve(int num1, int num2) {
        if (num1 == num2) {
            return 0;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();  // Each element in the queue is an array [currentNum, steps]
        queue.offer(new int[]{num1, 0});
        visited.add(num1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNum = current[0];
            int steps = current[1];

            for (int neighbor : getAdjacentPrimes(currentNum)) {
                if (neighbor == num2) {
                    return steps + 1;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new int[]{neighbor, steps + 1});
                }
            }
        }

        return -1;  // No valid path found
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] getAdjacentPrimes(int num) {
        int count = 0;  // Count the number of valid primes
        String numStr = String.valueOf(num);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j == 0) {
                    continue;  // Skip leading zeros
                }
                StringBuilder newNumStr = new StringBuilder(numStr);
                newNumStr.setCharAt(i, (char) ('0' + j));
                int newNum = Integer.parseInt(newNumStr.toString());
                if (isPrime(newNum)) {
                    count++;
                }
            }
        }

        int[] primes = new int[count];  // Use the correct size for the array
        count = 0;  // Reset count to use as an index for array assignment

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j == 0) {
                    continue;  // Skip leading zeros
                }
                StringBuilder newNumStr = new StringBuilder(numStr);
                newNumStr.setCharAt(i, (char) ('0' + j));
                int newNum = Integer.parseInt(newNumStr.toString());
                if (isPrime(newNum)) {
                    primes[count++] = newNum;
                }
            }
        }

        return primes;
    }
}
