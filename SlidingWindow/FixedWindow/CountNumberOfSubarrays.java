/*
Given an array A[] of N integers and a range(L, R).
The task is to find the number of subarrays having sum in the range L to R (inclusive).
https://practice.geeksforgeeks.org/problems/count-the-number-of-subarrays/1
TC: O(n)
SC: O(1)
*/

package SlidingWindow.FixedWindow;

public class CountNumberOfSubarrays {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8};
        int l = 4;
        int r = 13;
        int n = 4;
        System.out.println(countSubarray(n, arr, l, r));
    }

    // Function to count the number of subarrays whose sum is less than or equal to k
    static long count(int n, int[] arr, long k)
    {
        long sum = 0;               // Variable to store the current sum of elements
        long ans = 0;               // Variable to store the count of valid subarrays
        int l, r;
        for(l = 0, r = 0; r<n; r++)
        {
            sum += arr[r];
            while(sum > k)           //[1]
            {
                sum -= arr[l];
                l++;
            }
            ans += r - (l+1);       //[2]
        }
        return ans;
    }

    // Function to count the number of subarrays with sum in the range [l, r]
    static long countSubarray(int n,int arr[],long l,long r)
    {
        long ans1 = count(n, arr, l-1);    // Count the number of subarrays with sum less than l
        long ans2 = count(n, arr, r);         // Count the number of subarrays with sum less than or equal to r
        return ans2-ans1;                     // Return the count of subarrays with sum in the range [l, r]
    }
}

/*
The solution uses sliding window technique to count the number of subarrays whose sum falls within a specified range [l, r],
by calculating the difference between the counts of subarrays with sums less than or equal to r and those with sums less than l.

[1] if the sum exceeds k, move the left boundary to the right until the sum is less than or equal to k.
This step ensures that the sum of elements within the subarray remains within the desired range.
[2] count the number of subarrays ending at the current index (r) and add it to the answer.
After adjusting the left boundary, it calculates the number of subarrays ending at the current index (r) by subtracting (l + 1) from r.
This count represents the number of valid subarrays that end at the current index,
as the sum of elements within the subarray is less than or equal to the target sum(k).
*/
