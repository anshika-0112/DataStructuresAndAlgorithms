package LeetCode.Feburary;

/* Level- Easy (Topic -Arrays)
 Problem Statement:- In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is
 secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
 */
public class Feb_22_FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];

        for (int[] relation : trust) {
            trustCount[relation[0]]--;
            trustCount[relation[1]]++;
        }

        for (int i = 1; i <= n; ++i) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
