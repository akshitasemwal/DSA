/*
Given an array A[] of size N and a positive integer K,
find the first negative integer for each and every window(contiguous subarray) of size K.
https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
TC: O(n)
SC: O(n)
*/

package SlidingWindow.FixedWindow;
import java.util.*;

public class FirstNegativeIntegerInEveryWindow {
    public static void main(String[] args) {
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = 8;
        int k = 3;
        System.out.println(printFirstNegativeInteger(arr, n, k));
    }
    public static String printFirstNegativeInteger(long[] arr, int n, int k)
    {
        long[] ans = new long[n-k+1];
        Queue<Long> q = new LinkedList<>();
        int num = 0;
        int i = 0;
        int j = 0;
        while( j < n )
        {
            if( arr[j] < 0 )                 //[1]
            {
                q.add(arr[j]);
            }
            if( j - i + 1 == k )             //[2]
            {
                if(!q.isEmpty())
                {
                    ans[num] = q.peek();
                    num++;
                }
                else
                {
                    ans[num] = 0;
                    num++;
                }

                if(!q.isEmpty())
                {
                    if(arr[i] == q.peek())
                    {
                        q.remove();
                    }
                }
                i++;
            }
            j++;
        }
        return Arrays.toString(ans);
    }
}

/*
This solution aims to find and return the first negative integer in each window.

[1] if the jth index is negative, we add it to a queue, using fifo method.

[2] if the size of the window equals k, we will now have to do 2 operations:
-> calculating the result
For each window, we see if the queue still consists of any negative element.
If it does, the element at its front is added to the ans array.
If it does not, it means that the current window contains no negative integers,
and 0 needs to be added to the ans array for that particular window.

-> sliding the window forward by 1 character, and hence removing the effect of the ith index.
When sliding the window forward, we need to make sure that the results of the past window do not affect the current one.
If the queue is not empty, and the element at the ith index is still present at the font of the queue,
we will remove it from the queue as it is no longer required.

Next, we increase the i and j counter, to move the window forward by 1 step.
*/