/*
You are given an array consisting of n integers which denote the position of a stall.
You are also given an integer k which denotes the number of aggressive cows.
You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.
https://practice.geeksforgeeks.org/problems/aggressive-cows/1
TC: O(n log n)
SC: O(1)
*/

package BinarySearch;
import java.util.*;

public class MinimumMaxDistance {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] stalls = {10, 1, 2, 7, 5};
        System.out.println(solve(n, k, stalls));
    }

    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int l = 1;
        int r = stalls[n-1] - stalls[0];
        int mid = l + ( r - l ) / 2;
        int ans = r;
        while(l <= r)                                           //[1]
        {
            mid = l + ( r - l ) / 2;
            int count = 1;
            int j = 0;
            for(int i = 0; i<n; i++)                            //[2]
            {
                if( stalls[i] - stalls[j] >= mid )              //[3]
                {
                    count++;
                    j = i;
                }
            }
            if(count < k)                                       //[4]
            {
                r = mid - 1;
            }
            else                                                //[5]
            {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}

/*
The problem statement aims to find the distance between the stalls such that the minimum distance between any two stalls is maximum.

We use binary search approach to find the answer, i.e., the min distance.
[1] it maintains a 'count' variable to track the number of selected elements,
 and a 'j' pointer to keep track of the previous selected element's index.

[2] it uses a greedy approach, to iterate through the 'stalls' array and,
count the number of elements that can be selected with a minimum distance of 'mid'.

[3] if the distance between the current element and the previous selected element is greater than or equal to 'mid',
it increments the 'count' and updates 'j' to the current index.

[4] it checks if the 'count' is less than 'k'. If so, it means that it is not possible to select 'k' elements with a minimum distance of 'mid'.
In this case, it updates 'r' to 'mid - 1' to search for a smaller value in the lower range.

[5] if the 'count' is greater than or equal to 'k',
it updates the 'ans' to 'mid' and updates 'l' to 'mid + 1' to search for a larger value in the upper range.
*/