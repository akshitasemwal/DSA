/*
You are given an m x n integer matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
https://leetcode.com/problems/search-a-2d-matrix/description/
TC: O(n log m) n = no. of rows, m = no. of cols
SC: O(1)
*/

package BinarySearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 32;
        System.out.print(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i< matrix.length; i++)
        {
            int n = matrix[i].length;
            int l = 0;
            int r = n-1;
            int mid = l + ( r - l ) / 2;
            while( l <= r )
            {
                mid = l + ( r - l ) / 2;
                if( matrix[i][mid] < target )
                {
                    l = mid + 1;
                }
                else if( matrix[i][mid] > target )
                {
                    r = mid - 1;
                }
                else
                {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
This solution uses binary search method to find if a target is present in the matrix or not.
Instead of traversing the entire matrix in nested loops, we traverse each row,
and then use binary search operation to find the presence of the target.
*/