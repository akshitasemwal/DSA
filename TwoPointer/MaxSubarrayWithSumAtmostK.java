/*
Given an array of integers, our goal is to find the length of the largest subarray having the sum of its elements at most ‘k’ where k>0.
SC: O(1)
TC: O(n)
https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/
*/

package TwoPointer;

public class MaxSubarrayWithSumAtmostK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 1, 1, 0};
        int k = 4;
        maxSum(arr, k);
        maxSum2(arr, k);
    }

    static void maxSum2(int[] arr, int k)
    {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int sum = arr[i];
        int m = 0;
        while(i<n && j<n)
        {
            if(i==j)
            {
                if(sum>=k)
                {
                    i++;
                    j++;
                    sum = arr[i];
                }
                else
                {
                    int l = 1;
                    m = Math.max(l, m);
                    j++;
                    if( j<=n )
                    {
                        sum += arr[j];
                    }
                }
            }
            else if(sum>k)
            {
                sum -= arr[j];
                j--;
                sum-= arr[i];
                i++;
                if(i > j)
                {
                    j = i;
                }
            }
            else
            {
                int l = Math.abs(i - j) + 1;
                j++;
                if( j < n)
                {
                    sum += arr[j];
                }
                m = Math.max(l, m);
            }
        }
        System.out.println(m);
    }

    static void maxSum(int[] arr, int k)
    {

        int n = arr.length;
        int i = 0;
        int sum = 0;
        int l = 0;
        while( i<n)
        {
            sum = arr[i];
            int length = 1;
            int j = i+1;
            if(sum<=k)
            {
                while(j<n && sum <= k)
                {
                    sum+=arr[j];
                    length++;
                    j++;
                }
            }
            l = Math.max(l, length);
            i++;
        }
        System.out.println(l);
    }
}

/*
Try to find longest valid subarray starting at 1, 2, 3....n. This would be the brute force approach.

We notice that sum (arr[2]+..arr[j]) <= (arr[1]+..arr[j]) <= k, since sum remains constant, we dont need to calculate again.
For example, if we calculate arr[1]+...+arr[j], we dont have to calculate arr[2]+..+arr[j] since it was computed earlier too.


 */