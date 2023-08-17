/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together.
The efficient way is the one that involves the least number of multiplications.
The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1)
where the ith matrix has the dimensions (arr[i-1] x arr[i]).
https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
TC: O(n*n*n)
SC: O(n*n)
*/

package DynamicProgramming.MatrixChainMultiplication;

public class MCM {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = 5;
        System.out.println(matrixMultiplication(n, arr));
    }

    static int solve(int[] arr, int i, int j, int[][] dp)          //[1]
    {
        if( i == j )                                               //[2]
        {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(dp[i][j] != -1)                                         //[3]
        {
            return dp[i][j];
        }
        for(int k = i; k<j; k++)                                   //[4]
        {
            int cost = solve(arr, i, k, dp) + solve(arr, k+1, j, dp) + (arr[i-1] * arr[k] * arr[j]); //[5]
            min = Math.min(cost, min);
        }
        return dp[i][j] = min;                                     //[6]
    }

    static int matrixMultiplication(int n, int arr[])
    {
        int i = 1;
        int j = n-1;
        int[][] dp = new int[n+1][n+1];
        for(int l = 0; l<n+1; l++)
        {
            for(int m = 0; m<n+1; m++)
            {
                dp[l][m] = -1;
            }
        }
        return solve(arr, i, j, dp);
    }
}

/*
[1] it calculates the minimum multiplications needed to multiply a sequence of matrices,with dimensions specified in the array.
This function is a recursive helper function that calculates the minimum cost of multiplying matrices from index i to j in the array arr.

[2] the base case if (i == j) returns 0, indicating that a single matrix does not require any multiplication.

[3] if the value has already been calculated, it is directly returned from the memoization table.

[4] a loop iterates through possible partition points k between i and j and calculates the cost of multiplying matrices on both sides of k.
The cost is the sum of costs for the two subproblems and the cost of multiplying the resulting matrices at positions i-1, k, and j.

[5] calculates the cost of multiplying matrices from index i to k(left subproblem),
and the cost of multiplying matrices from index k+1 to j(right subproblem).

(arr[i-1] * arr[k] * arr[j]): This part calculates the cost of multiplying the resulting matrices after the two subproblems are solved.
Since arr represents the dimensions of the matrices, arr[i-1] * arr[k] * arr[j] gives the number of scalar multiplications required
to multiply the matrices at indices i-1, k, and j.
When we multiply two matrices, the number of scalar multiplications needed to compute each entry of the resulting matrix
is determined by the dot product of the corresponding row of the first matrix and column of the second matrix.
In the context of the matrix chain multiplication problem, this dot product involves the dimensions of three matrices:
the matrix at index i-1, the matrix at index k, and the matrix at index j.

So, arr[i-1] * arr[k] * arr[j] represents the total number of multiplications needed to compute the product of these three matrices.

[5] The minimum cost among all possible partition points is stored in min.
Finally, the minimum cost is memoized in dp[i][j] and returned.
*/