/*
You are given an integer n and a 0-indexed 2D array queries where queries[i] = [typei, indexi, vali].
Initially, there is a 0-indexed n x n matrix filled with 0's. For each query, you must apply one of the following changes:
if typei == 0, set the values in the row with indexi to vali, overwriting any previous values.
if typei == 1, set the values in the column with indexi to vali, overwriting any previous values.
Return the sum of integers in the matrix after all queries are applied.
https://leetcode.com/problems/sum-of-matrix-after-queries/description/
TC: O(n)
SC: O(n)
*/

package LeetcodeContests.WeeklyContest348;
import java.util.*;

public class SumOfMatrixAfterQueries {
    public static void main(String[] args) {
        int n = 3;
        int[][] queries = {{0,0,4},{0,1,2},{1,0,1},{0,2,3},{1,2,1}};
        System.out.println(matrixSumQueries(n, queries));
    }
        public static long matrixSumQueries(int n, int[][] queries) {
            int r = n;
            int c = n;
            int m = queries.length;
            Set<Integer> visitedRows = new HashSet<>();
            Set<Integer> visitedCols = new HashSet<>();
            long sum = 0;
            for(int i = m-1; i>=0; i--)                      //[1]
            {
                int index = queries[i][1];
                int val = queries[i][2];
                if(queries[i][0] == 0 && !visitedRows.contains(index))
                {
                    sum += (long) c*val;
                    visitedRows.add(index);
                    r--;
                }
                else if(queries[i][0] == 1 && !visitedCols.contains(index))
                {
                    sum += (long) r*val;
                    visitedCols.add(index);
                    c--;
                }
            }
            return sum;
    }
}

/*
The optimal solution for this problem involves traversing the queries in reverse order.
This is done because now we can simply add all the required elements, instead of subtracting the elements which would later be overwritten.

[1] if the type of query is 0, it means the elements will be inserted in a row of given index.
When we do so, we have to see thet how many columns are available in that particular row, and hence we multiply the value by the number of available columns.
Now, after utilizing a row, we decrement the count of the rows.
The exact opposite is done when the type of the query is 1.
*/