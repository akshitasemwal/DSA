/*
Alice and Bob each created one problem for HackerRank.
A reviewer rates the two challenges, awarding points on a scale from 1 to 100 for three categories: problem clarity, originality, and difficulty.
If a[i] > b[i], then Alice is awarded 1 point.
If a[i] < b[i], then Bob is awarded 1 point.
If a[i] = b[i], then neither person receives a point.
TC: O(n)
SC: O(1)
https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true
 */

package Easy;

import java.util.*;

public class CompareTheTriplets {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(17, 28, 30);
        List<Integer> b = Arrays.asList(99, 16, 8);
        System.out.println(compareTriplets(a, b));
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>();
        int alice = 0, bob = 0;
        for(int i = 0; i < 3; i++){
            if(a.get(i) > b.get(i))
            {
                alice++;
            }
            else if(a.get(i) < b.get(i))
            {
                bob++;
            }
        }
        res.add(alice);
        res.add(bob);
        return res;
    }
}
