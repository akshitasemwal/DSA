/*
you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
You have to figure out a way to get both kangaroos at the same location at the same time as part of the show.
If it is possible, return YES, otherwise return NO.
x1<x2
https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true
TC: O()
SC: O()
 */

package Easy;

public class NumberLineJumps {
    public static void main(String[] args) {
        int x1 = 0, v1 = 3;
        int x2 = 4, v2 = 2;
        System.out.println(kangaroo(x1, v1, x2, v2));
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int flag = 0;
        while(x1<x2)
        {
            x1 += v1;
            x2 += v2;
            if(x1 == x2)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 1)
        {
            return("YES");
        }
        return ("NO");
    }
}
