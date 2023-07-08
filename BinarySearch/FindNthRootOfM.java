/*
You are given two positive integers, 'n' and 'm'. You have to return the nth root of m.
If the nth root is not an integer, return -1.
https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679?topList=top-maths-and-number-theory-questions
TC: O(log n)
SC: O(1)
*/

package BinarySearch;

public class FindNthRootOfM {
    public static void main(String[] args) {
        int m = 81;
        int n = 4;
        System.out.println(root(m, n));
    }

    public static int root( int m, int n )
    {
        int l = 1;
        int r = m;
        int mid = l + ( r - l ) / 2;
        while ( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if( Math.pow(mid, n) == m )
            {
                return mid;
            }
            else if ( Math.pow(mid, n) > m)              //[1]
            {
                r = mid - 1;
            }
            else if( Math.pow(mid, n) < m )              //[2]
            {
                l = mid + 1;
            }
        }
        return -1;
    }
}

/*
This solution could also be found in linear time by using a loop running from 1 to n.
1 to the power of n < 2 to the power of n < 3 to the power of n....
We notice that the number line formed is a monotonic increasing function and hence,
we use binary search algorithm to optimize the solution and find the nth root of m in log n time.

m to the power of (1/n) = x
If we multiply both the sides by n, we get: m = x to the power of n.
Now, we have to find x such that x to the power of n will be m.

The search space available for x is: 1 to m.
Let l be 1, and r be m. mid = l + ( r - l ) / 2

Instead of traversing through all the elements 1 by 1, we check if mid to the power of n is greater than or less than m.
[1] if it is greater than m, it means that the element cannot be present on the right side of mid and hence r pointer can be updated.
[2] if it is smaller than m, it means that the element cannot be present on the left side of the mid and hence l pointer can be updated.

As soon as the desired element is found, i.e., mid to the power of n == m, mid is returned.
If no such element is found, -1 is returned.
*/
