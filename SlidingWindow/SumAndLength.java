/*
Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
Lily decides to share a contiguous segment of the bar selected such that:
The length of the segment matches Ron's birth month, and,
The sum of the integers on the squares is equal to his birth day.
Determine how many ways she can divide the chocolate.
https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=true
TC: O(n)
SC: O(1)
 */

package SlidingWindow;

import java.util.*;

public class SumAndLength {
    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(1, 2, 1, 3, 2);
        int d = 3, m = 2;
        System.out.println(birthday(s, d , m));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        if(m>s.size()) return 0;
        int sum = 0;    //to check sum == d
        int count = 0;  //to check m == count
        int ways = 0;
        int i = 0;
        while ( i < s.size() )
        {
            sum += s.get(i);
            count++;
            if( count == m && sum == d )            //[1]
            {
                ways++;
                count--;
                sum -= s.get(i-count);
            }
            else if( count == m )                   //[2]
            {
                count--;
                sum -= s.get(i-count);
            }
            i++;
        }
        return ways;
    }
}

/*
This sliding window based problem iterates over the given list and returns the total no. of ways the chocolate can be divided
such that the sum of the numbers on selected pieces is equal to the given day, and the length of cholate is equal to the month.
[1] it checks if the count(length of selected chocolate) == m(month) && sum of the numbers == given sum. If it is true,
ways is incremented, while the length of the selected chocolate is decremented to slide the window(length) over the next required length.
and the sum of the dropped element is also removed from the calculated sum.
[2] if count == m, but the window length is not equivalent, the window moves forward by dropping the element from left and decreasing the calculated sum.
 */