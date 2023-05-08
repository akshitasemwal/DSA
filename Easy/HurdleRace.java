/*
A video player plays a game in which the character competes in a hurdle race.
Hurdles are of varying heights, and the characters have a maximum height they can jump. T
here is a magic potion they can take that will increase their maximum jump height by 1 unit for each dose.
How many doses of the potion must the character take to be able to jump all of the hurdles.
If the character can already clear all of the hurdles, return 0.
https://www.hackerrank.com/challenges/the-hurdle-race/problem?isFullScreen=true
TC: O(n)
SC: O(1)
*/

package Easy;
import java.util.*;

public class HurdleRace {
    public static void main(String[] args) {
        int k = 1;
        List<Integer> arr = Arrays.asList(2, 4, 5, 3, 2);
        System.out.println(hurdleRace(k, arr));
    }

    public static int hurdleRace(int k, List<Integer> height) {
        int max = height.get(0);
        for(int i = 0; i<height.size(); i++)
        {
            if( height.get(i) > max)
            {
                max = height.get(i);
            }
        }
        if( max > k)
            return max-k;
        else
            return 0;
    }
}
