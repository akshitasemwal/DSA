/*
Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
https://www.hackerrank.com/challenges/time-conversion/problem?isFullScreen=true
TC: O(1)
SC: O(n) since not inplace
 */

package Easy;

public class TimeConversionIMP {
    public static void main(String[] args) {
        String s = "07:05:45PM";
        System.out.println(timeConversion(s));
    }
    public static String timeConversion(String s) {
        String start = s.substring(0,2);
        String end = s.substring(2,8);
        int hour = Integer.parseInt(start);
        if( s.charAt(8)=='P')
        {
            hour = hour + 12;
        }
        else if( s.charAt(8) == 'A' && hour == 12 )
        {
            hour = 0;
        }
        return ( hour + end );
    }
}
