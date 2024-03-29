/*
Given sorted array of size N. Find the index of upper bound of x.
TC: O(log n)
SC: O(1)
*/

package BinarySearch;

public class UpperBound {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 7, 9, 12, 13, 17, 19};
        int x = 10;
        System.out.println(upperBound(arr, x));
    }

    public static int upperBound(int[] arr, int x)
    {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int mid = l + ( r - l ) / 2;
        int index = 0;
        while( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if( arr[mid] <= x )                       //[1]
            {
                l = mid+1;
            }
            else                                       //[2]
            {
                r = mid - 1;
            }
        }
        return arr[l];
    }
}

/*
Upper bound: first number in the sorted array which is greater than a given number, and closest to it.

[1] to find the upper bound, we will start checking if the mid element is greater or less than x.
If it is less than or equal to x, he left array can be neglected and l gets updated to mid+1.
l is also a candidate for upperbound element.

[2] if it is greater than x, we neglect the right side of the array, completely.

We return the element at l index, because l all the candidates for upperbounds are stored at l.
*/