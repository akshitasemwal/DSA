/*
Maria plays college basketball and wants to go pro. Each season she maintains a record of her play.
She tabulates the number of times she breaks her season record for most points and least points in a game.
Points scored in the first game establish her record for the season, and she begins counting from there.
https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=true
TC: O(n)
SC: O(1)
 */

package Easy;

import java.util.*;

public class BreakingRecords {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);
        System.out.println(breakingRecords(scores));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int n = scores.size();
        int minScore = 0, maxScore = 0;
        int currMin = scores.get(0);
        int currMax = scores.get(0);
        for(int i = 1; i<n; i++)
        {
            if(scores.get(i) > currMax)
            {
                currMax = scores.get(i);
                maxScore++;
            }
            if(scores.get(i) < currMin)
            {
                currMin = scores.get(i);
                minScore++;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(maxScore);
        res.add(minScore);
        return res;
    }
}
