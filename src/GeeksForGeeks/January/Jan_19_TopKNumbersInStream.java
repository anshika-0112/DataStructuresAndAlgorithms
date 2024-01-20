package GeeksForGeeks.January;

import java.util.*;

/* Level - Medium
    Problem Statement:- Given N numbers in an array, your task is to keep at most the top K numbers with respect to their frequency.
        Input:
        N=5, K=4
        arr[] = {5, 2, 1, 3, 2}
        Output:
        5
        2 5
        1 2 5
        1 2 3 5
        2 1 3 5
        Explanation:
        Firstly there was 5 whose frequency is max till now. So resulting sequence is {5}.
        Then came 2, which is smaller than 5 but their frequencies are same so resulting sequence is {2, 5}.
        Then came 1, which is the smallest among all the numbers arrived, so resulting sequence is {1, 2, 5}.
        Then came 3 , so resulting sequence is {1, 2, 3, 5}
        Then again 2, which has the highest frequency among all numbers, so resulting sequence {2, 1, 3, 5}.
*/
public class Jan_19_TopKNumbersInStream {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int currentElement = arr[i];

            frequencyMap.put(currentElement, frequencyMap.getOrDefault(currentElement, 0) + 1);

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                    (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue()
            );

            pq.addAll(frequencyMap.entrySet());

            ArrayList<Integer> currentIteration = new ArrayList<>();

            for (int j = 0; j < K && !pq.isEmpty(); j++) {
                currentIteration.add(pq.poll().getKey());
            }

            result.add(new ArrayList<>(currentIteration));
        }

        return result;
    }
}
