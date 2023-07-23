/*
Given an array of non-negative integers, and a value sum.
Determine if there is a subset of the given set with sum equal to given sum.
https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
SC: O(sum*N)
TC: O(sum*N)
*/

package DynamicProgramming.Knapsack;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = 6;
        System.out.println(isSubsetSum(n, arr, sum));
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean dp[][] = new boolean[N+1][sum+1];             //[1]

        for(int i = 0; i < N+1; i++)
        {
            for(int j = 0; j < sum+1; j++)
            {

                if(i >= 0 && j == 0)                          //[2]
                {
                    dp[i][0] = true;
                }

                if(i == 0 && j > 0)                           //[3]
                {
                    dp[0][j] = false;
                }

                if(i > 0 && j > 0)                            //[4]
                {
                    if(arr[i-1] <= j)                         //[5]
                    {
                        dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                    }
                    else                                      //[6]
                    {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[N][sum];
    }
}

/*
[1] create a 2D boolean array dp of size (N+1) x (sum+1).
dp[i][j] will represent whether there exists a subset of the first i elements in the array that sums up to j.

[2,3] initialize the base cases:
when the sum is 0 (j == 0), for any number of elements i >= 0, there is always an empty subset that sums up to 0. So, set dp[i][0] = true.
When the number of elements is 0 (i == 0), and the sum is greater than 0 (j > 0), there is no subset possible, so set dp[0][j] = false.

[4] this condition checks whether the current cell (i, j) is not in the first row or the first column of the dp table.
The first row and the first column of the dp table are used for base cases.

[5] this code checks whether the current element arr[i-1] (we use i-1 to match the 0-based indexing of the array)
is less than or equal to the target sum j. If it is, then we have two choices:

Include the current element arr[i-1] in the subset:
In this case, we check whether there exists a subset with a sum of j - arr[i-1] in the previous row (i.e., dp[i-1][j - arr[i-1]]).
We use the OR (||) operator because if there exists a subset with the sum of j - arr[i-1],
then including the current element will form a subset with the sum of j. So, we set dp[i][j] to true.

Exclude the current element arr[i-1] from the subset: In this case,
we simply use the value from the previous row and same column, i.e., dp[i-1][j], and set dp[i][j] to this value.

[6] If arr[i-1] is greater than j, it means that the current element cannot be included in the subset to achieve the sum of j.
So, we directly copy the value from the previous row and same column, i.e., dp[i][j] = dp[i-1][j].
*/