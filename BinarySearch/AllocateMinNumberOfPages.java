/*
You have N books, each with Ai number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
The goal is to find the permutation where the student with the most pages allocated to him gets the minimum number of pages,
out of all possible permutations.
https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n log n)
SC: O(1)
*/

package BinarySearch;

public class AllocateMinNumberOfPages {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {12,34,67,90};
        int m = 2;
        System.out.println(findPages(arr, n, m));
    }

    public static boolean lessThanEqual(int mid, int[]arr, int n, int m)   //[1]
    {
        int sum = 0;
        int parts = 1;
        for(int i = 0; i<n; i++)
        {
            if( arr[i] > mid )                                             //[2]
            {
                return false;
            }
            sum += arr[i];
            if( sum > mid )
            {
                parts++;
                sum = arr[i];
            }
            if( parts > m )
            {
                return false;
            }
        }
        return true;
    }

    public static int findPages(int[]arr,int n,int m)           //[3]
    {
        if( n<m ) return -1;
        int l = 1;
        int r = 0;
        int ans = 0;
        for(int i = 0; i<n; i++)
        {
            r += arr[i];
        }
        int mid = l + ( r - l ) / 2;
        while( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if( lessThanEqual(mid, arr, n, m) )                   //[4]
            {
                r = mid - 1;
                ans = mid;
            }
            else
            {
                l = mid + 1;
            }
        }
        return ans;
    }
}


/*
Divide n size array into m no. of subarrays such that the sum of the max length subarray is minimum.

[1] this method checks if it is possible to allocate 'mid' pages to 'm' students.
It uses a greedy approach, to iterate through the array of pages and keeps track of the sum of pages allocated so far.

[2] if the sum exceeds 'mid', it increments the 'parts' counter (number of students used) and resets the sum to the current page value.
If the number of parts exceeds 'm', it returns false, indicating that it is not possible to allocate 'mid' pages to 'm' students.
If the entire array is processed without exceeding 'mid' and the number of parts is less than or equal to 'm', it returns true.

[3] this function checks if the number of pages is less than the number of students.
If so, it returns -1 because it is not possible to allocate pages to more students than the available pages.

[4] if 'mid' is a valid solution, it updates 'ans' to 'mid' and continues searching for a smaller value in the lower range (l to mid-1).
If 'mid' is not a valid solution, it searches for a larger value in the upper range (mid+1 to r).
The binary search continues until 'l' becomes greater than 'r', indicating that the search is complete.
*/