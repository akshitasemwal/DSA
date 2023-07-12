/*
Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.
https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
TC: O(log(r) * R * log(C))
SC: O(1)
*/

package BinarySearch;

public class MedianInARowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        int r = 3;
        int c = 3;
        System.out.print(median(matrix, r, c));
    }

    public static int median(int matrix[][], int R, int C) {
        int N = R * C;
        int medianIndex = N/2;

        int l = 1;                     // Assigning given constraints
        int r = 2000;

        while (l <= r){
            int mid = l + (r-l)/2;
            int smallerElements = findSmallerElements(matrix, mid);        //[1]
            if ( smallerElements <= medianIndex )                          //[2]
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return l;
    }

    static int findSmallerElements(int matrix[][], int prevMid){

        int noOfSmallerElements = 0;
        for (int i=0; i<matrix.length; i++)
        {
            int l = 0;
            int r = matrix[i].length - 1;
            while (l <= r)                                           //[3]
            {
                int mid = l + ( r - l ) / 2;
                if ( matrix[i][mid] <= prevMid )
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid-1;
                }
            }
            noOfSmallerElements += l;
        }
        return noOfSmallerElements;
    }
}

/*
Brute force method: flatten into an array of size r*c, and return the median of the array.

Optimal solution: binary search and upperbound technique

We calculate the no. of values less than or equal to mid.
We then compare it with the median index, to check if it is a possible match or not.
It is a possible match if the number of elements less than or equal to it == median index.

For each number in the search space, we check for the number of elements less than or equal to it, present in the matrix.
We break this process into two parts: access the array row-wise, and search for the values less than or equal to the mid(current element in search space).
For searching these values, we use the "upperbound" method.
We do so because upperbound of the element will return the index of the upperbound of mid, using which we can know the number of values less than or equal to mid,
as all the values before that index satisfy this condition.

Next, we compare the values than or equal to the mid, with each element

[1] implementing function to calculate number of values less than or equal to the mid. It is done to shrink the search space.

[2] since we know that the median will lie close to the middle index, i.e., (r*c)/2,
we will compare these values to check if the current element(mid) lies to the left or the right of the middle index.
For example, if the middle index is 7, and for current element 10, number of values less than or equal to it are 9, it definitely means that 10 lies on the right part of middle index,
and right side can be neglected to shrink the search space and update r = mid - 1.
We use <= so that all the possible candidates can be stored in the l, and hence we return l at the end.

[3] for each row in the matrix, we calculate the upperbound on the mid element, to return the number of values less than or equal to it.
We then sum up all the values for all the rows, and then send it back to be compared as mentioned in [2].
*/
