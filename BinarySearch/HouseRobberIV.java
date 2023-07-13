/*
There are several consecutive houses along a street, each of which has some money inside.
There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
You are given an integer array nums representing how much money is stashed in each house.
More formally, the ith house from the left has nums[i] dollars.
You are also given an integer k, representing the minimum number of houses the robber will steal from.
It is always possible to steal at least k houses.
Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
https://leetcode.com/problems/house-robber-iv/description/
TC: O(n log m) n = nums.length, m = 10^9
SC: O(1)
*/

package BinarySearch;

public class HouseRobberIV {
    public static void main(String[] args) {
        int[] nums = { 4, 7, 9, 3, 2, 1};
        int k = 2;
        System.out.println(minCapability(nums, k));
    }

    public static int minCapability(int[] nums, int k) {
        int l = 1;
        int r = 1000000000;
        int ans = r;                                 //stores the current minimum capability
        int mid = l + ( r - l ) / 2;

        while ( l <= r )                             //[1]
        {
            mid = l + ( r - l ) / 2;
            int c = 0;
            for(int i = 0; i < nums.length; i++)    //[2]
            {
                if(nums[i] <= mid)
                {
                    i++;                            //extra i skipped to check for alternate elements only
                    c++;
                }
            }
            if( c>=k )                              //[3]
            {
                ans = Math.min( ans, mid);
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return ans;                                //[4]
    }
}

/*
The search space goes from l = 1 to r = 10^9, as mentioned in the constraints of the question.

[1] this loop performs a binary search to find the minimum capability that satisfies the condition:
having at least k elements in the nums array less than or equal to that capability.

[2] inside the loop, calculate the count c of elements in the nums array that are less than or equal to the current mid capability.
Iterate through each element in the nums array and increment c whenever an element is less than or equal to mid.

[3] cf c is greater than or equal to k, update the ans variable with the current mid value and search for a lower capability.
Update r = mid - 1 to search in the lower half of the remaining range.
If c is less than k, the current mid capability is not sufficient to satisfy the condition.
Search for a higher capability by setting l = mid + 1 to search in the upper half of the remaining range.

[4] once the while loop terminates, the ans variable will hold the minimum capability
that satisfies the condition of having at least k elements in the nums array less than or equal to that capability.
Hence, ans wil be returned.
*/