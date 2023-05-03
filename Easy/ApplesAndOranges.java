/*
Determine the number of apples and oranges that land on Sam's house.
Assume the trees are located on a single point, where the apple tree is at point a, and the orange tree is at point b.
When a fruit falls from its tree, it lands d units of distance from its tree of origin along the x-axis.
*A negative value of d means the fruit fell d units to the tree's left, and a positive value of d means it falls d units to the tree's right.*
https://www.hackerrank.com/challenges/apple-and-orange/problem?isFullScreen=true
TC: O(n)
SC: O(1)
 */

package Easy;

import java.util.Arrays;
import java.util.List;

public class ApplesAndOranges {
    public static void main(String[] args) {
        int s = 7, t = 11;
        int a = 5, b = 15;
        List<Integer> apples = Arrays.asList(-2, 2, 1);
        List<Integer> oranges = Arrays.asList(5, -6, -4);
        countApplesAndOranges(s, t, a, b, apples, oranges);
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int ap = 0, or = 0;
        for(Integer num : apples)
        {
            if((num+a) >= s && (num+a) <=t)
            {
                ap++;
            }
        }
        for(Integer num : oranges)
        {
            if((num+b) >= s && (num+b) <=t)
            {
                or++;
            }
        }
        System.out.println(ap);
        System.out.println(or);
    }
}
