package GeeksForGeeks.January;

import java.util.ArrayList;
import java.util.Collections;

/*  Level - Medium
Problem Statement:- Given an array gallery[] consisting of n integers, where gallery[i] is the range of the sprinkler at partition i (a power of -1 indicates no sprinkler attached), return the minimum number of sprinklers that need to be turned on to water the entire gallery. If there is no possible way to water the full length using the given sprinklers, print -1.

    Example 1:

    Input:
    n = 6
    gallery[] = {-1, 2, 2, -1, 0, 0}
    Output:
    2
    Explanation:
    Sprinklers at index 2 and 5
    can water the full gallery, span of
    sprinkler at index 2 = [0,4] and span
    of sprinkler at index 5 = [5,5].

    Logic:- We will first find that how much range a particular sprinkler is covering. Then we will sort the array of ranges,
    and then we will try to maximize our right range.

 */
public class Jan_18_WaterPlants {
    int min_sprinklers(int[] gallery, int n) {
        ArrayList<int[]> sprinklers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (gallery[i] != -1) {
                int left = Math.max(0, i - gallery[i]);
                int right = Math.min(n - 1, i + gallery[i]);
                sprinklers.add(new int[]{left, right});
            }
        }

        Collections.sort(sprinklers, (a, b) -> a[0] - b[0]);

        int sprinklerCount = 0;
        int i = 0;
        int target = 0;

        while (i < sprinklers.size() && target < n) {
            int maxRight = -1;

            while (i < sprinklers.size() && sprinklers.get(i)[0] <= target) {
                maxRight = Math.max(maxRight, sprinklers.get(i)[1]);
                i++;
            }

            if (maxRight == -1) {
                return -1;
            }

            sprinklerCount++;
            target = maxRight + 1;
        }

        return target >= n ? sprinklerCount : -1;
    }
}
