/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
https://leetcode.com/problems/sqrtx/description/
SC: O(1)
TC: O(log n)
*/

package BinarySearch;

public class Sqrt {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        int l = 1;
        int r = x;
        int ans = 0;
        int mid = l + ( r - l ) / 2;
        while ( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if( mid * mid == x )                          //[1]
            {
                return mid;
            }
            else if( (long) mid * mid > (long) x )        //[2]
            {
                r = mid - 1;
            }
            else if( mid * mid < x )                      //[3]
            {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}

/*
To find the square root of a given number, we use binary search algorithm to traverse through the entire search space.

[1] if the square of the mid is equal to x, mid is returned.
[2] otherwise, if the square of mid is greater than x, the right side of the mid is neglected and r pointer gets updated.
(long) is used because as given in the example, if the square of the mid exceeds the MAX_INTEGER,
it can check for any arbitrary value because of bits overflow, which will hence give the wrong answer.
[3] otherwise, if the square of mid is less than x, mid is stored in a variable ans, since it is a possible answer,
because we have to return the number such that its square, when rounded off to nearest integer, is x.
*/