/*
Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array.
Let the sum of the element of these two subsets be S1 and S2.
Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference S1 and S2 is equal to d.
Since the answer may be large return it modulo 109 + 7.
https://practice.geeksforgeeks.org/problems/partitions-with-given-difference/1
TC: O( N * sum )
SC: O( N * sum )
*/

package DynamicProgramming.Knapsack;

public class CountOfSubsetsWithGivenDifference {
    public static void main(String[] args) {
        int n = 4;
        int d = 3;
        int[] arr =  { 5, 2, 6, 4 };
        System.out.println(countPartitions(n, d, arr));
    }

    public static int subsetSum(int[] arr, int n, int sum)            //[1]
    {
        int[][] dp = new int[n+1][sum+1];
        for(int i = 0; i<n+1; i++)
        {
            for(int j = 0; j<sum+1; j++)
            {
                if(i == 0)
                {
                    dp[i][j] = 0;   //single empty subset
                }
                if(j == 0)
                {
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 1; i<n+1; i++)
        {
            for(int j = 0; j<sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static int countPartitions(int n, int d, int arr[])
    {
        int sum = 0;
        for(int i = 0; i<n; i++)                                      //[2]
        {
            sum += arr[i];
        }
        sum += d;                                                    //[3]
        if( sum % 2 != 0) return 0;
        sum /= 2;
        return subsetSum(arr, n, sum);                               //[4]
    }
}

/*
The problem aims at finding the count of subarrays such that when the elements in each subarray are added,
they sum upto s1 and s2, and the absolute difference between s1 and s2 should be equal to d.

We observe that:
s1 - s2 = d
s1 + s2 = sum of the entire array.

On adding both the equations, 2 * s1 = sum of the array + given difference.
Therefore, s1 = (sum + d) / 2
Now the problem has been reduced to finding the count of subset such that its sum is: (sum - d)/2.

[1] this function implements the count of subset with given sum function, and returns the number of subsets which fulfill the desired criteria.
[2] the sum of the entire array is calculated.
[3] now, the sum is calculated according to the given statement: s1 = (sum + d) / 2.
We also check if ( sum + d ) is divisible by 2 or not, because if it is not divisible by 2,
then it simply will not be possible to divide the sum into 2 parts, such tha both the parts are whole numbers.
If it is not divisible by 2, we return 0 as the no. of possible subsets.
[4] now, we call the subset sum function to calculate the no. of subsets with the newly calculated sum.
*/